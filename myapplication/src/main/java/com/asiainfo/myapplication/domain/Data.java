package com.asiainfo.myapplication.domain;

/**
 * Created by zhouliang on 2017/4/25.
 */

public class Data {
    private String tv_name;
    private String iv_url;
    private int layout_type;

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getIv_url() {
        return iv_url;
    }

    public void setIv_url(String iv_url) {
        this.iv_url = iv_url;
    }

    public int getLayout_type() {
        return layout_type;
    }

    public void setLayout_type(int layout_type) {
        this.layout_type = layout_type;
    }

    @Override
    public String toString() {
        return "Data{" +
                "tv_name='" + tv_name + '\'' +
                ", iv_url='" + iv_url + '\'' +
                ", layout_type=" + layout_type +
                '}';
    }
}
