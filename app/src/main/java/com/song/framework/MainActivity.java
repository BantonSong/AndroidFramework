package com.song.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.song.framework.model.DetailModel;
import com.song.framework.network.MyObserver;
import com.song.framework.network.Network;

public class MainActivity extends AppCompatActivity {
    private TextView tvDetail;
    private Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvDetail = (TextView) findViewById(R.id.tvDetail);
        btnRequest = (Button) findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }

    private void request() {
        Network.getApiService()
                .query("一心一意")
                .subscribe(new MyObserver<DetailModel>(MainActivity.this) {
                    @Override
                    public void onNext(DetailModel model) {
                        tvDetail.setText(model.getContent());
                    }
                });
//                Network.getApiService().queryArray("一心一意").subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<List<DetailModel>>(MainActivity.this) {
//                    @Override
//                    public void onNext(List<DetailModel> model) {
//                        if (model != null && model.size() > 0) {
//                            tvDetail.setText(model.get(0).getContent());
//                        }
//                    }
//                });
//                Network.getApiService().queryString("").subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<String>(MainActivity.this) {
//                    @Override
//                    public void onNext(String model) {
//                        tvDetail.setText(model);
//                    }
//                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ((MyApplication) getApplication()).appExit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
