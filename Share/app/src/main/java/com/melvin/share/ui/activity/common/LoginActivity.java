package com.melvin.share.ui.activity.common;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;

import com.melvin.share.R;
import com.melvin.share.Utils.CodeUtils;
import com.melvin.share.databinding.ActivityLoginBinding;
import com.melvin.share.ui.activity.common.BaseActivity;


/**
 * Created by Administrator on 2016/1/13.
 * 登录页面
 */
public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private Context context;
    //产生的验证码
    private String realCode;
    private ImageView iv_showCode;

    //初始化界面
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        context = this;
        initWindow();
        iv_showCode = binding.ivShowCode;
        initToolbar(binding.toolbar);
        initData();
    }

    private void initData() {
        //将验证码用图片的形式显示出来s
        iv_showCode.setImageBitmap(CodeUtils.getInstance().createBitmap());
    }

    /**
     * 刷新验证码
     *
     * @param view
     */
    public void refreshCerificationCode(View view) {
        iv_showCode.setImageBitmap(CodeUtils.getInstance().createBitmap());
        realCode = CodeUtils.getInstance().getCode();
    }

    /**
     * 注册
     *
     * @param view
     */
    public void clickRegister(View view) {
        startActivity(new Intent(context, RegisterFirstActivity.class));
    }

}
