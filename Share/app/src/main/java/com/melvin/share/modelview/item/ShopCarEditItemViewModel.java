package com.melvin.share.modelview.item;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.CompoundButton;

import com.melvin.share.Utils.RxBus;
import com.melvin.share.model.User;
import com.melvin.share.ui.activity.ProductInfoActivity;

/**
 * Created Time: 2016/8/7.
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能：购物车编辑页面item的ViewModel
 */
public class ShopCarEditItemViewModel extends BaseObservable {

    private User user;
    private Context context;
    private String number = "1";

    public ShopCarEditItemViewModel(Context context, User user) {
        this.user = user;
        this.context = context;
    }

    public void onItemClick(View view) {
        context.startActivity(new Intent(context, ProductInfoActivity.class));
    }

    public String getNumber() {
        return number;
    }

    public void onAddClick(View view) {
        this.number = Integer.parseInt(number) + 1 + "";
        notifyChange();

    }

    public void onDeleteClick(View view) {
        this.number = ((Integer.parseInt(number) - 1) == 0) ? "0" : (Integer.parseInt(number) - 1 + "");
        notifyChange();
    }

    /**
     * 勾选状态判断,修改值后，以便操作之时TemplateViewModel可以利用到
     *
     * @return
     */
    public CompoundButton.OnCheckedChangeListener getChoiceListener() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                RxBus.get().post("hello"+isChecked);
            }
        };
    }

    public String getImgUrl() {
        return "http://h.hiphotos.baidu.com/image/h%3D300/sign=ff62800b073b5bb5a1d726fe06d2d523/a6efce1b9d16fdfa7807474eb08f8c5494ee7b23.jpg";
    }

    public void setEntity(User user) {
        this.user = user;
        notifyChange();
    }
}
