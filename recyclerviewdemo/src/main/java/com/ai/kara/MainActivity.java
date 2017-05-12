package com.ai.kara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.ViewGroup;

import com.ai.kara.view.QuanQuanView;
import com.ai.kara.view.TongjiView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        QuanQuanView view = new QuanQuanView(this);
//        view.moveView();
//        setContentView(view);
        TongjiView view = new TongjiView(this);
        LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , 400);
        view.setLayoutParams(params);
        setContentView(view);
        view.setYLine(0, 100, 20);//Y轴开始最小值 ，最大值  ，间隔
        view.setXLine(0, 10, 1);//X轴开始最小值 ，最大值  ，间隔
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 20);
        map.put(2, 80);
        map.put(3, 37);
        map.put(4, 17);
        map.put(5, 59);
        map.put(6, 90);
        map.put(7, 100);
        view.setData(map);
    }
}
