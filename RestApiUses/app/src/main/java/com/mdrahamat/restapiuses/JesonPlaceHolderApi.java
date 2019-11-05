package com.mdrahamat.restapiuses;


import android.telecom.Call;

import java.util.List;

import retrofit2.Call;

public interface JesonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPost();
}
