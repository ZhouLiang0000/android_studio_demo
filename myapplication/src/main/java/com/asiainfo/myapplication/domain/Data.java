package com.asiainfo.myapplication.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhouliang on 2017/4/25.
 */

public class Data implements Parcelable {
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

    public Data() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tv_name);
        dest.writeString(this.iv_url);
        dest.writeInt(this.layout_type);
    }

    protected Data(Parcel in) {
        this.tv_name = in.readString();
        this.iv_url = in.readString();
        this.layout_type = in.readInt();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
