package com.melvin.share.ui.fragment.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melvin.share.R;
import com.melvin.share.Utils.LogUtils;
import com.melvin.share.adapter.QrcodeAdapter;
import com.melvin.share.databinding.FragmentQrCodeBinding;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/7/17
 * <p/>
 * 描述：二维码分享
 */
public class QRcodeFragment extends BaseFragment {

    private FragmentQrCodeBinding binding;
    private Context mContext;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_qr_code, container, false);
        mContext = getActivity();
        LogUtils.i("QRcodeFragment+initView");
        initTable();
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
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
