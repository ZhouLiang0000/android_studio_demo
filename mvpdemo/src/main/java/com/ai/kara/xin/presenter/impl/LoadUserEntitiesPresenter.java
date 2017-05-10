package com.ai.kara.xin.presenter.impl;

import com.ai.kara.xin.model.IGetUserEntitiesListener;
import com.ai.kara.xin.model.IUserModel;
import com.ai.kara.xin.model.entity.UserEntity;
import com.ai.kara.xin.model.impl.UserModelImpl;
import com.ai.kara.xin.presenter.ILoadUserEntitiesPresenter;
import com.ai.kara.xin.view.ILoadDataView;

import java.util.List;

/**
 * Created by zhouliang on 2017/5/10.
 */

public class LoadUserEntitiesPresenter implements ILoadUserEntitiesPresenter{
    private ILoadDataView<UserEntity> mILoadListView;
    private IUserModel mUserModel;

    public LoadUserEntitiesPresenter(ILoadDataView<UserEntity> mILoadListView) {
        this.mILoadListView = mILoadListView;
        this.mUserModel = new UserModelImpl();
    }

    @Override
    public void loadUserEntities() {
        mILoadListView.startLoading();
        mUserModel.loadUserEntities(new IGetUserEntitiesListener() {
            @Override
            public void onGetUserEntities(List<UserEntity> userEntities) {
                if (userEntities != null && !userEntities.isEmpty()) {
                    mILoadListView.loadSuccess(userEntities);
                } else {
                    mILoadListView.loadFailed();
                }
                mILoadListView.finishLoading();
            }
        });
    }
}
