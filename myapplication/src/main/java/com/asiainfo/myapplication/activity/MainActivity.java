package com.asiainfo.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.asiainfo.myapplication.R;
import com.asiainfo.myapplication.adapter.MyRecyclerAdapter;
import com.asiainfo.myapplication.domain.Data;
import com.asiainfo.myapplication.view.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView = null;
    private List<Data> listData = null;
    private MyRecyclerAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initData() {
        listData = new ArrayList<Data>();
        for (int x = 0; x < 100; x++) {
            Data data = new Data();
            data.setTv_name("我是条目--" + x);
            data.setIv_url("https://kara-image.asiainfo.com/scale/personheadicon/18DF979E8F5E463997658F9EEE1D7FE3.png");
            if(x % 5 == 0){
                data.setLayout_type(0);
            }else{
                data.setLayout_type(1);
            }
            listData.add(data);
        }
        recycleAdapter = new MyRecyclerAdapter(MainActivity.this, listData);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        recyclerView.setAdapter(recycleAdapter);
        //设置分隔线
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recycleAdapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,"点击了条目"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {

            }
        });
    }
}
