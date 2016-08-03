package com.melvin.share.ui.fragment.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melvin.share.R;
import com.melvin.share.Utils.LogUtils;
import com.melvin.share.databinding.FragmentSelfBinding;
import com.melvin.share.ui.activity.ShopCollectionActivity;
import com.melvin.share.ui.activity.WaitPayActivity;
import com.melvin.share.ui.activity.common.LoginActivity;
import com.melvin.share.ui.activity.selfcenter.ManageAddressActivity;
import com.melvin.share.ui.activity.selfcenter.MyRebateActivity;
import com.melvin.share.ui.activity.selfcenter.OpenshopFirstActivity;
import com.melvin.share.ui.activity.selfcenter.SettingActivity;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/17
 * <p>
 * 描述：个人中心
 */
public class SelfFragment extends BaseFragment implements View.OnClickListener {

    private FragmentSelfBinding binding;
    private Context mContext;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_self, container, false);
        mContext = getActivity();
        LogUtils.i("SelfFragment+initView");
        bingClick();
        return binding.getRoot();
    }

    /**
     * 绑定点击事件
     */
    private void bingClick() {

        binding.clickAvatar.setOnClickListener(this);
        binding.clickProductCollection.setOnClickListener(this);
        binding.clickShopCollection.setOnClickListener(this);
        binding.clickScanHistory.setOnClickListener(this);

        binding.clickOrderExamine.setOnClickListener(this);
        binding.clickWaitPay.setOnClickListener(this);
        binding.clickWaitSendProduct.setOnClickListener(this);
        binding.clickWaitReceiveProduct.setOnClickListener(this);

        binding.clickMyRebate.setOnClickListener(this);
        binding.clickOpenShop.setOnClickListener(this);
        binding.clickVip.setOnClickListener(this);
        binding.clickReceiveAddress.setOnClickListener(this);

        binding.clickQueryHelp.setOnClickListener(this);
        binding.clickAboutUs.setOnClickListener(this);
        binding.clickSetting.setOnClickListener(this);

    }

    /**
     * 点击事件分发
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.click_avatar://头像登录
                intent.setClass(mContext, LoginActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.click_product_collection://商品收藏
                intent.setClass(mContext, LoginActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.click_shop_collection://店铺收藏
                intent.setClass(mContext, ShopCollectionActivity.class);
                mContext.startActivity(intent);

                break;
            case R.id.click_scan_history://浏览历史

                break;

            case R.id.click_order_examine://订单

                break;
            case R.id.click_wait_pay://待付款
                intent.setClass(mContext, WaitPayActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.click_wait_send_product://待发货

                break;
            case R.id.click_wait_receive_product://待收货

                break;


            case R.id.click_my_rebate://我的返现
                intent.setClass(mContext, MyRebateActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.click_open_shop://我要开店
                intent.setClass(mContext, OpenshopFirstActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.click_vip://升级超级会员

                break;

            case R.id.click_receive_address://收货地址
                intent.setClass(mContext, ManageAddressActivity.class);
                mContext.startActivity(intent);
                break;

            case R.id.click_query_help://咨询与帮助

                break;
            case R.id.click_about_us://关于我们

                break;
            case R.id.click_setting://设置
                intent.setClass(mContext, SettingActivity.class);
                mContext.startActivity(intent);
                break;

        }

    }
}
