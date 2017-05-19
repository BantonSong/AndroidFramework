package com.song.framework.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.song.framework.exception.MyException;
import com.song.framework.model.ResponseModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by songyawei on 2017/4/13.
 */
public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private static String TAG = MyGsonResponseBodyConverter.class.getSimpleName();

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
//            String json = value.string(); TODO
            String json = "{\"status\":\"0\",\"msg\":\"ok\",\"result\":{\"name\":\"一心一意\",\"pronounce\":\"yī  xīn  yī  yì\",\"content\":\"只有一个心眼儿，没有别的考虑。\",\"comefrom\":\"《三国志·魏志·杜恕传》：“免为庶人，徙章武郡，是岁嘉平元年。”裴松之注引《杜氏新书》：“故推一心，任一意，直而行之耳。”\",\"antonym\":[\"三心二意\",\"心猿意马\"],\"thesaurus\":[\"全心全意\",\"一心一意\",\"真心实意\"],\"example\":\"1. 但美国公司比中国要更一心一意地追逐利益。\\r\\n                                                                                                2. 珍妮特做每一件事情总是一心一意的。\\r\\n                                                                                                3. 我只想一心一意把这个项目做好。\\r\\n                                                                                                4. 虽然rosneft目前说，尽管他现在是政府控股，但其管理是独立的，比俄罗斯天然气公司这个天然气巨头更一心一意的注重商业\"}}";
//            String json = "{\"status\":\"0\",\"msg\":\"ok\",\"result\":[{\"name\":\"一心一意\",\"pronounce\":\"yī  xīn  yī  yì\",\"content\":\"只有一个心眼儿，没有别的考虑。\",\"comefrom\":\"《三国志·魏志·杜恕传》：“免为庶人，徙章武郡，是岁嘉平元年。”裴松之注引《杜氏新书》：“故推一心，任一意，直而行之耳。”\",\"antonym\":[\"三心二意\",\"心猿意马\"],\"thesaurus\":[\"全心全意\",\"一心一意\",\"真心实意\"],\"example\":\"1. 但美国公司比中国要更一心一意地追逐利益。 2. 珍妮特做每一件事情总是一心一意的。 3. 我只想一心一意把这个项目做好。 4. 虽然rosneft目前说，尽管他现在是政府控股，但其管理是独立的，比俄罗斯天然气公司这个天然气巨头更一心一意的注重商业\"},{\"name\":\"一心一意\",\"pronounce\":\"yī  xīn  yī  yì\",\"content\":\"只有一个心眼儿，没有别的考虑。\",\"comefrom\":\"《三国志·魏志·杜恕传》：“免为庶人，徙章武郡，是岁嘉平元年。”裴松之注引《杜氏新书》：“故推一心，任一意，直而行之耳。”\",\"antonym\":[\"三心二意\",\"心猿意马\"],\"thesaurus\":[\"全心全意\",\"一心一意\",\"真心实意\"],\"example\":\"1. 但美国公司比中国要更一心一意地追逐利益。 2. 珍妮特做每一件事情总是一心一意的。 3. 我只想一心一意把这个项目做好。 4. 虽然rosneft目前说，尽管他现在是政府控股，但其管理是独立的，比俄罗斯天然气公司这个天然气巨头更一心一意的注重商业\"}]}";
//            String json = "{\"status\":\"0\",\"msg\":\"ok\",\"result\":\"test\"}";
//            String json = "{\"status\":\"0\",\"msg\":\"ok\",\"result\":{}}";
            Log.e(TAG, json);

            ResponseModel responseModel = gson.fromJson(json, ResponseModel.class);

            if (!"0".equals(responseModel.getStatus())) {
                throw new MyException(MyException.ERR_CODE_SERVER, responseModel.getErrMsg());
            }
            return adapter.fromJson(responseModel.getResult().toString());
        } finally {
            value.close();
        }
    }
}
