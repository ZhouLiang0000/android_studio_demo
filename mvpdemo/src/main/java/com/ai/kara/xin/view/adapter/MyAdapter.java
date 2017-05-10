package com.ai.kara.xin.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ai.kara.xin.R;
import com.ai.kara.xin.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouliang on 2017/5/10.
 */

public class MyAdapter extends BaseAdapter {
    private List<UserEntity> mUserModels;
    private Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        this.mUserModels = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mUserModels != null ? mUserModels.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mUserModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = viewHolder.bindVIew();
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bindData(position);
        return convertView;
    }

    public void addDatas(List<UserEntity> modelList) {
        if (modelList == null || modelList.isEmpty()) {
            return;
        }
        mUserModels.addAll(modelList);
    }

    public void removeDatas() {
        mUserModels.clear();
    }

    public class ViewHolder {

        private TextView mTextView;

        public View bindVIew() {
            View convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview, null);
            mTextView = (TextView) convertView.findViewById(R.id.test_textview);
            return convertView;
        }

        public void bindData(int position) {
            UserEntity userModel = mUserModels.get(position);
            mTextView.setText(String.format("name:%s \nage:%d", userModel.getName(), userModel.getAge()));
        }
    }

}
