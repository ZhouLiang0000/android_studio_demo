package com.ai.kara.xin.model.impl;

import android.os.Handler;
import android.os.Looper;

import com.ai.kara.xin.model.IGetUserEntitiesListener;
import com.ai.kara.xin.model.IUserModel;
import com.ai.kara.xin.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouliang on 2017/5/10.
 */

public class UserModelImpl implements IUserModel {
    @Override
    public void loadUserEntities(final IGetUserEntitiesListener listener) {
        //模拟网络请求数据过程
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<UserEntity> userModels = new ArrayList<>();
                int testCount = 20;
                for (int i = 0; i < testCount; i++) {
                    UserEntity userModel = new UserEntity();
                    userModel.setAge(i * 5);
                    userModel.setName(String.format("李%d", i));
                    userModels.add(userModel);
                }
                listener.onGetUserEntities(userModels);
            }
        }, 3000);
    }
}
