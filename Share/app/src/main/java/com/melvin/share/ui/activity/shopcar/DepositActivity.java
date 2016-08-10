package com.melvin.share.ui.activity.shopcar;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.Gravity;
import android.view.View;

import com.aigestudio.wheelpicker.widget.curved.WheelDatePicker;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.melvin.share.R;
import com.melvin.share.Utils.RxCommonBus;
import com.melvin.share.Utils.Utils;
import com.melvin.share.databinding.ActivityDepositBinding;
import com.melvin.share.databinding.ActivitySettingBinding;
import com.melvin.share.dialog.TimeDialog;
import com.melvin.share.popwindow.SexPopupWindow;
import com.melvin.share.ui.activity.common.AmendPasswordActivity;
import com.melvin.share.ui.activity.common.AmendPhoneActivity;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.ui.activity.common.CityTransparentActivity;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/8/10
 * <p>
 * 描述： 提现
 */
public class DepositActivity extends BaseActivity {
    private ActivityDepositBinding binding;
    private Context mContext = null;
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deposit);
        mContext = this;
        initWindow();
        initToolbar(binding.toolbar);
    }

    private void ininData() {

    }

}
