package com.example.commutils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chenenyu.router.annotation.Route;

/**
 * Created by zhouliang on 2017/5/18.
 */
@Route("first")
public class FirstActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView view = new TextView(this);
        Bundle msg = getIntent().getBundleExtra("tag");
        view.setText(msg.getString("tag1"));
        setContentView(view);
    }
}
