package com.asiainfo.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.asiainfo.myapplication.R;
import com.asiainfo.myapplication.service.PollingService;
import com.asiainfo.myapplication.utils.PollingUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /*启动*/
    private Button bt_start = null;
    /*停止*/
    private Button bt_stop = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_stop = (Button) findViewById(R.id.bt_stop);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_stop.setOnClickListener(this);
        bt_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_stop:
                PollingUtils.stopPollingService(this, PollingService.class, PollingService.ACTION);
            break;
            case R.id.bt_start:
                PollingUtils.startPollingService(this, 1, PollingService.class, PollingService.ACTION);
                break;
            default:
            break;
        }
    }
}
