package com.song.framework.network;

import android.content.Context;
import android.net.ParseException;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.song.framework.exception.MyException;
import com.song.framework.util.NetworkUtil;

import org.json.JSONException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * 必须运行在UI线程里，异常处理中有UI操作
 * Created by songyawei on 2017/4/21.
 */
public abstract class MyObserver<T> implements Observer<T> {
    private Context context;

    public MyObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (!NetworkUtil.isNetworkConnected(context)) {
            d.dispose();
            Log.e(MyObserver.class.getSimpleName(), "网络错误，请检查网络设置并重试！");
        }
        // 加载中对话框，请求三秒后显示取消按钮 TODO

    }

    /**
     * 处理共通的异常,如果有独特的异常处理可以在子类中单独实现
     * 可以弹对话框、Toast等
     */
    @Override
    public void onError(Throwable throwable) {
        // 取消加载中对话框 TODO
        //获取最根源的异常
        while (throwable.getCause() != null) {
            Log.e(MyObserver.class.getSimpleName(), throwable.getMessage());
            throwable = throwable.getCause();
        }

        MyException myException;
        if (throwable instanceof HttpException) {
            //HTTP错误
            myException = new MyException(MyException.ERR_CODE_HTTP);
        } else if (throwable instanceof MyException) {    //服务器返回的错误
            myException = (MyException) throwable;
        } else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException
                || throwable instanceof ParseException) {
            myException = new MyException(MyException.ERR_CODE_JSON);
        } else {
            myException = new MyException(MyException.ERR_CODE_UNKNOWN);
        }

        Toast.makeText(context, myException.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
        // 取消加载中对话框 TODO
    }
}
