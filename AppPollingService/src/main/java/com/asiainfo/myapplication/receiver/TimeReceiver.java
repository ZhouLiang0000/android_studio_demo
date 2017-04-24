package com.asiainfo.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by zhouliang on 2017/4/20.
 */

public class TimeReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.example.servicedemo.TimeReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ACTION.equals(action)) {
            Log.e(getClass().getSimpleName(),"============TimeReceiver");
            Toast.makeText(context, "定时任务", Toast.LENGTH_SHORT).show();
        }
    }
}
