package com.melvin.share.modelview.item;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.melvin.share.Utils.LogUtils;
import com.melvin.share.model.Product;
import com.melvin.share.model.User;
import com.melvin.share.network.GlobalUrl;
import com.melvin.share.ui.activity.ProductInfoActivity;

/**
 * Created Time: 2016/8/4.
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能：彩妆页面item的ViewModel
 */
public class MarkupItemViewModel extends BaseObservable {

    private Product product;
    private Context context;

    public MarkupItemViewModel(Context context, Product product) {
        this.product = product;
        this.context = context;
    }

    public void onItemClick(View view) {
        context.startActivity(new Intent(context, ProductInfoActivity.class));
    }

    public String getImgUrl() {
        String[] split = product.picture.split("\\|");
        if (split != null && split.length >= 1) {
            String url = GlobalUrl.SERVICE_URL + split[2];
            LogUtils.e("哈哈"+url);
            return url;
        }
        return "";
    }

    public String getShareTimes() {
        return product.shareTimes;
    }

    public String getProductName() {
        return product.productName;
    }

    public String getPrice() {
        return "￥:"+product.price;
    }

    public String getPlace() {
        return product.place;
    }

    public void setEntity(Product product) {
        this.product = product;
        notifyChange();
    }
}
