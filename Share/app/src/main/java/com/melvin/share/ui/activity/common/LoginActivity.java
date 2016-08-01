package com.melvin.share.ui.activity.common;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.melvin.share.R;
import com.melvin.share.databinding.ActivityLoginBinding;
import com.melvin.share.ui.activity.common.BaseActivity;


/**
 * Created by Administrator on 2016/1/13.
 * 登录页面
 */
public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private Context context;

    //初始化界面
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        context = this;
        initWindow();
        initToolbar(binding.toolbar);
        initData();
    }

    private void initData() {

    }

    /**
     * 注册
     * @param view
     */
    public void clickRegister(View view) {
        startActivity(new Intent(context, RegisterFirstActivity.class));
    }

}
