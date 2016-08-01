package com.melvin.share.ui.activity.common;

import android.databinding.DataBindingUtil;

import com.melvin.share.R;
import com.melvin.share.databinding.ActivityRegisterSBinding;
import com.melvin.share.ui.activity.common.BaseActivity;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/21
 * <p>
 * 描述：注册第二页
 */
public class RegisterSecondActivity extends BaseActivity {
    private ActivityRegisterSBinding binding;

    //初始化界面
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_second);
        initWindow();
        initToolbar(binding.toolbar);
        initData();
    }

    private void initData() {

    }

}
