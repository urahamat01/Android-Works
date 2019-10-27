package com.mdrahamat.firebaseapplication;

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload() {
        //emty constructor create
    }

    public Upload(String mName, String mImageUrl) {
        if (mName.trim().equals("")){
            mName="No Name ";
        }
        this.mName = mName;
        this.mImageUrl = mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
