package com.asiainfo.android_studio_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.chenenyu.router.annotation.Route;

/**
 * Created by zhouliang on 2017/5/18.
 */
@Route("test1")
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView view = new TextView(this);
        view.setText("testActivity");
        setContentView(view);
    }
}
