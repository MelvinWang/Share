package com.melvin.share.ui.fragment.main;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.WriterException;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.melvin.share.R;
import com.melvin.share.Utils.LogUtils;
import com.melvin.share.Utils.RxBus;
import com.melvin.share.Utils.Utils;
import com.melvin.share.adapter.QrcodeAdapter;
import com.melvin.share.databinding.FragmentQrCodeBinding;
import com.melvin.share.view.SelectPicPopupWindow;
import com.melvin.share.zxing.encoding.EncodingHandler;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/7/17
 * <p/>
 * 描述：二维码分享
 */
public class QRcodeFragment extends BaseFragment {
    //自定义的弹出框类
    SelectPicPopupWindow menuWindow;
    private FragmentQrCodeBinding binding;
    private Context mContext;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_qr_code, container, false);
        mContext = getActivity();
        menuWindow = new SelectPicPopupWindow((Activity) mContext, itemsOnClick);
        LogUtils.i("QRcodeFragment+initView");
        initTable();
        return binding.getRoot();
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.wechat_share:
                    Utils.showToast(mContext, "wechat_share");
                    break;
                case R.id.friends_share:
                    Utils.showToast(mContext, "friends_share");
                    break;
                case R.id.qq_share:
                    Utils.showToast(mContext, "qq_share");
                    break;
                case R.id.qq_zone_share:
                    Utils.showToast(mContext, "qq_zone_share");
                    break;
                default:
                    break;
            }

        }

    };

    @Override
    public void onStart() {
        super.onStart();
        RxBus.get().register(this); //注册
    }

    @Override
    public void onStop() {
        super.onStop();
        RxBus.get().unregister(this);//销毁
    }

    //接收一个消息，消息区别是通过参数，因此这里接收一个post事件，参数为字串时，这里就可以收到。
    @Subscribe
    public void qrcode(String qrcodeString) {
        //显示窗口,设置layout在PopupWindow中显示的位置
        menuWindow.showAtLocation(binding.coordinatorLayout, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        try {
            Bitmap qrCodeBitmap = EncodingHandler.createQRCode(qrcodeString, 1000);
            menuWindow.setImgview(qrCodeBitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化标题,绑定
     */
    private void initTable() {
        QrcodeAdapter viewPagerAdapter = new QrcodeAdapter(getChildFragmentManager(), getActivity());
        binding.viewpager.setAdapter(viewPagerAdapter);//设置适配器
        TabLayout mTabLayout = binding.tablayout;
        mTabLayout.setupWithViewPager(binding.viewpager);
    }
}
