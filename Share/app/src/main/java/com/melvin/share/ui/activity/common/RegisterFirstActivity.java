package com.melvin.share.ui.activity.common;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.melvin.share.R;
import com.melvin.share.databinding.ActivityRegisterFBinding;
import com.melvin.share.ui.activity.common.BaseActivity;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/21
 * <p>
 * 描述：注册第一页
 */
public class RegisterFirstActivity extends BaseActivity {
    private ActivityRegisterFBinding binding;
    private Context context;

    //初始化界面
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_first);
        context = this;
        initWindow();
        initToolbar(binding.toolbar);
        initData();
    }

    private void initData() {

    }

    /**
     * 下一步
     *
     * @param view
     */
    public void clickNext(View view) {
        startActivity(new Intent(context, RegisterSecondActivity.class));
    }

}
