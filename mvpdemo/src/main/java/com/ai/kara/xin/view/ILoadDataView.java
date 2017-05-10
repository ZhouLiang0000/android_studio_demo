package com.ai.kara.xin.view;

import java.util.List;

/**
 * Created by zhouliang on 2017/5/10.
 */

public interface ILoadDataView<T> {
    void startLoading();//开始加载

    void loadFailed();//加载失败

    void loadSuccess(List<T> list);//加载成功

    void finishLoading();//结束加载
}
