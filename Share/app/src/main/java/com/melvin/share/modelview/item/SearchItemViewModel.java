package com.melvin.share.modelview.item;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.melvin.share.model.User;

/**
 * Created Time: 2016/8/3.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：搜索item的ViewModel
 */
public class SearchItemViewModel extends BaseObservable {

    private User user;
    private Context context;

    public SearchItemViewModel(Context context, User user) {
        this.user = user;
        this.context = context;
    }

    public void onItemClick(View view) {

    }

    public void setEntity(User user) {
        this.user = user;
        notifyChange();
    }
}
