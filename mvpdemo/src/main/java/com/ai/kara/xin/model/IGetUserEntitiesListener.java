package com.ai.kara.xin.model;

import com.ai.kara.xin.model.entity.UserEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/5/10.
 */

public interface IGetUserEntitiesListener {
    void onGetUserEntities(List<UserEntity> userEntities);
}
