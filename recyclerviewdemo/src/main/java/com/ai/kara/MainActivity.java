package com.ai.kara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ai.kara.view.QuanQuanView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        QuanQuanView view = new QuanQuanView(this);
        setContentView(view);
        view.moveView();
    }
}
