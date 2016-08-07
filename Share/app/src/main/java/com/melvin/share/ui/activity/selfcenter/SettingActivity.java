package com.melvin.share.ui.activity.selfcenter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.melvin.share.R;
import com.melvin.share.databinding.ActivitySettingBinding;
import com.melvin.share.ui.activity.common.AmendPasswordActivity;
import com.melvin.share.ui.activity.common.AmendPhoneActivity;
import com.melvin.share.ui.activity.common.BaseActivity;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/7/24
 * <p/>
 * 描述： 设置
 */
public class SettingActivity extends BaseActivity {
    private ActivitySettingBinding binding;
    private Context mContext = null;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        mContext = this;
        initWindow();
        initToolbar(binding.toolbar);
    }

    private void ininData() {

    }

    /**
     * 修改手机
     *
     * @param v
     */
    public void amendPhone(View v) {
        startActivity(new Intent(mContext, AmendPhoneActivity.class));
    }

    /**
     * 修改密码
     *
     * @param v
     */
    public void amendPassword(View v) {
        startActivity(new Intent(mContext, AmendPasswordActivity.class));
    }


}
