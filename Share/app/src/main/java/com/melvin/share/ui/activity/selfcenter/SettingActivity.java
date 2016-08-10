package com.melvin.share.ui.activity.selfcenter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import com.aigestudio.wheelpicker.widget.curved.WheelDatePicker;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.melvin.share.R;
import com.melvin.share.Utils.DateUtil;
import com.melvin.share.Utils.RxCommonBus;
import com.melvin.share.Utils.Utils;
import com.melvin.share.databinding.ActivitySettingBinding;
import com.melvin.share.dialog.TimeDialog;
import com.melvin.share.popwindow.SexPopupWindow;
import com.melvin.share.ui.activity.common.AmendPasswordActivity;
import com.melvin.share.ui.activity.common.AmendPhoneActivity;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.ui.activity.common.CityTransparentActivity;

import java.io.File;
import java.util.Date;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/24
 * <p>
 * 描述： 设置
 */
public class SettingActivity extends BaseActivity {
    private ActivitySettingBinding binding;
    private Context mContext = null;
    private SexPopupWindow sexPopupWindow;
    private String sex;
    protected int padding;
    protected int textSize;
    protected int itemSpace;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        mContext = this;
        //时间参数
        padding = getResources().getDimensionPixelSize(R.dimen.MyWheelPadding);
        textSize = getResources().getDimensionPixelSize(R.dimen.MyTextSizeLarge);
        itemSpace = getResources().getDimensionPixelSize(R.dimen.MyItemSpaceLarge);
        sexPopupWindow = new SexPopupWindow(this, itemsOnClick);
        initWindow();
        RxCommonBus.get().register(this); //注册
        initToolbar(binding.toolbar);
    }

    private void ininData() {

    }


    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            sexPopupWindow.dismiss();
            switch (v.getId()) {
                case R.id.sex_cancel:
                    sexPopupWindow.dismiss();
                    break;
                case R.id.sex_confirm:
                    binding.tvSex.setText(sex);
                    break;
            }

        }

    };


    @Subscribe
    public void sexSelect(String sex) {
        this.sex = sex;
    }


    /**
     * 修改性别
     *
     * @param v
     */
    public void amendSex(View v) {
        sexPopupWindow.showAtLocation(binding.root, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    /**
     * 修改生日
     *
     * @param v
     */
    public void amendBirthDay(View v) {
        TimeDialog dialog = new TimeDialog(mContext);
        WheelDatePicker wheelDatePicker = Utils.createWheelDate(mContext, padding, textSize, itemSpace);
        dialog.setContentView(wheelDatePicker);
        dialog.show();
        dialog.setOnConfirmListener(new TimeDialog.OnConfirmListener() {
            @Override
            public void onConFirmClick(String timeResult) {
                binding.tvBirthDay.setText(timeResult);
            }
        });
    }

    /**
     * 修改居住地
     *
     * @param v
     */
    public void amendAddress(View v) {
        Intent intent = new Intent();
        intent.setClass(mContext, CityTransparentActivity.class);
        startActivityForResult(intent, 10);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxCommonBus.get().unregister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (data != null) {
                String result = data.getExtras().getString("result");
                String[] split = result.split("-");
                binding.tvAddress.setText(split[0]);
            }
        }
    }

}
