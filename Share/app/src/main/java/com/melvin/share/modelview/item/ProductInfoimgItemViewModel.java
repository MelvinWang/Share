package com.melvin.share.modelview.item;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.melvin.share.model.User;

/**
 * Created Time: 2016/7/23.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：单个商品item的ViewModel
 */
public class ProductInfoimgItemViewModel extends BaseObservable {

    private User user;
    private Context context;

    public ProductInfoimgItemViewModel(Context context, User user) {
        this.user = user;
        this.context = context;
    }

    public void onItemClick(View view) {

    }

    public String getImgUrl() {
        return "http://imgstore.cdn.sogou.com/app/a/100540002/486230.jpg";
    }

    public void setEntity(User user) {
        this.user = user;
        notifyChange();
    }
}
