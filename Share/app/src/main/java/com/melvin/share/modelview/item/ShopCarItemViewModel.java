package com.melvin.share.modelview.item;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.CompoundButton;

import com.melvin.share.Utils.RxCarBus;
import com.melvin.share.model.User;
import com.melvin.share.ui.activity.ProductInfoActivity;

/**
 * Created Time: 2016/7/23.
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能：购物车item的ViewModel
 */
public class ShopCarItemViewModel extends BaseObservable {

    private User user;
    private Context context;
    private boolean isShowEdit = true;
    private boolean isShowDone = false;
    private String number = "1";

    public ShopCarItemViewModel(Context context, User user) {
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


    public boolean getIsShowEdit() {
        return isShowEdit;
    }

    public void setIsShowEdit(boolean b) {
        this.isShowEdit = b;
    }

    public boolean getIsShowDone() {
        return isShowDone;
    }

    public void setIsShowDone(boolean b) {
        this.isShowDone = b;
    }

    public void edit(View view) {
        setIsShowEdit(false);
        setIsShowDone(true);
        notifyChange();
    }

    public void done(View view) {
        setIsShowEdit(true);
        setIsShowDone(false);
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
                RxCarBus.get().post("hello"+isChecked);
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
