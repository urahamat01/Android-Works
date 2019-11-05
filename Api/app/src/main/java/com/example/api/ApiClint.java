package com.example.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClint {

    private static String BASE_URL ="https://jsonplaceholder.typicode.com/";

    private static ApiClint mInstance;
    private Retrofit retrofit;

    public ApiClint() {
       /* retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();*/
       
       retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
    .build();
    }

    public static ApiClint getInstance(){
        if (mInstance == null){
            mInstance = new ApiClint();
        }
        return mInstance;
    }

    public RetrofitInterface getApi(){
        return retrofit.create(RetrofitInterface.class);
    }
}
