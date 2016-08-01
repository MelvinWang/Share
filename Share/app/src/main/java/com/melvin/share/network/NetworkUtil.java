package com.melvin.share.network;


import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created Time: 2016/7/17.
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能：网络请求工具及其接口
 */
public class NetworkUtil {
    //总请求路径
    public static final String API_URL = GlobalUrl.SERVICE_URL;
    private static Retrofit sRetrofit;

    //定义接口
    public interface FromNetwork {
        //登录
//        @FormUrlEncoded
//        @POST("auth/login")
//        Observable<LoginReturn> rxLogin(@FieldMap Map<Object, Object> login);


    }

    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.interceptors().add(new TokenInterceptor());
            sRetrofit = new Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }


}



