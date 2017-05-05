package com.asiainfo.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asiainfo.myapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ActivityButtonActivity extends Activity {


    @InjectView(R.id.bt1)
    Button bt1;
    @InjectView(R.id.bt2)
    Button bt2;
    @InjectView(R.id.bt3)
    Button bt3;
    @InjectView(R.id.tv_text)
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                tv_text.setText("点击了按钮1");
                break;
            case R.id.bt2:
                break;
            case R.id.bt3:
                break;
        }
    }
}
