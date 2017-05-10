package com.ai.kara.xin.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.ai.kara.xin.R;
import com.ai.kara.xin.model.entity.UserEntity;
import com.ai.kara.xin.presenter.impl.LoadUserEntitiesPresenter;
import com.ai.kara.xin.view.ILoadDataView;
import com.ai.kara.xin.view.adapter.MyAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ILoadDataView<UserEntity>{

    private MyAdapter mMyAdapter;
    private ProgressDialog mProgressDialog;
    private LoadUserEntitiesPresenter mLoadListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ListView testListView = (ListView) findViewById(R.id.test_listView);
        mMyAdapter = new MyAdapter(this);
        testListView.setAdapter(mMyAdapter);
        mLoadListPresenter = new LoadUserEntitiesPresenter(this);
        findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyAdapter.removeDatas();
                mMyAdapter.notifyDataSetChanged();
                mLoadListPresenter.loadUserEntities();
            }
        });
    }

    @Override
    public void startLoading() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载中");
        mProgressDialog.show();
    }

    @Override
    public void loadFailed() {

    }

    @Override
    public void loadSuccess(List<UserEntity> list) {
        mMyAdapter.addDatas(list);
        mMyAdapter.notifyDataSetChanged();
    }

    @Override
    public void finishLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
