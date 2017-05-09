package com.example.commutils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.commutils.R;

/**
 * Created by zhouliang on 2017/5/9.
 */

public class SecondActivity extends Activity implements View.OnClickListener{
    private Button bt_anniu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);
        bt_anniu = (Button) findViewById(R.id.bt_anniu);
        bt_anniu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_anniu){
            Toast.makeText(SecondActivity.this, "点击了按钮new_button", Toast.LENGTH_SHORT).show();
        }
    }

}
