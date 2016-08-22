package com.melvin.share.network;


import com.melvin.share.model.Category;
import com.melvin.share.model.Product;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created Time: 2016/7/17.
 * <p>
 * Author:Melvin
 * <p>
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
        //首页分类
        @POST("/app/category/findAll")
        Observable<ArrayList<Category>> categoryFind();
        //首页推荐
        @FormUrlEncoded
        @POST("/app/product/findProductsInHomePage")
        Observable<ArrayList<Product>> findProductsInHomePage(@FieldMap Map<Object, Object> map);
        @FormUrlEncoded
        //首页每个分类详情
        @POST("/app/product/findProductsByCategory")
        Observable<ArrayList<Product>> findProductsByCategory(@FieldMap Map<Object, Object> map);


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



