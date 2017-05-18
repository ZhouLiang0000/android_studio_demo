package com.asiainfo.android_studio_demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.chenenyu.router.RouteTable;
import com.chenenyu.router.Router;
import com.example.commutils.activity.SecondActivity;

import java.util.Map;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt_anniu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        bt_anniu = (Button) findViewById(R.id.bt_anniu);
        bt_anniu.setOnClickListener(this);
//        Router.addRouteTable(new RouteTable() {
//            @Override
//            public void handle(Map<String, Class<?>> map) {
//                map.put("test", SecondActivity.class);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_anniu:
                Router.build("testSecond").go(this);
                break;
        }
    }
}
