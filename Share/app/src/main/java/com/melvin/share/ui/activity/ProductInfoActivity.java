package com.melvin.share.ui.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;

import com.melvin.share.R;
import com.melvin.share.adapter.MyRebateAdapter;
import com.melvin.share.adapter.ProductInfoAdapter;
import com.melvin.share.databinding.ActivityProductInfoBinding;
import com.melvin.share.ui.activity.common.BaseActivity;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/7/25
 * <p/>
 * 描述：产品信息
 */
public class ProductInfoActivity extends BaseActivity {
    private ActivityProductInfoBinding binding;
    private Context mContext = null;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_info);
        mContext = this;
        initWindow();
        initToolbar(binding.toolbar);
        initTable();
    }

    /**
     * 初始化标题,绑定
     */
    private void initTable() {
        ProductInfoAdapter viewPagerAdapter = new ProductInfoAdapter(getSupportFragmentManager(), this);
        binding.viewpager.setAdapter(viewPagerAdapter);//设置适配器
        TabLayout mTabLayout = binding.tablayout;
        mTabLayout.setupWithViewPager(binding.viewpager);
    }


}


