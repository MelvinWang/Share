package com.melvin.share.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.view.Gravity;
import android.view.View;

import com.melvin.share.R;
import com.melvin.share.adapter.ProductInfoAdapter;
import com.melvin.share.databinding.ActivityProductInfoBinding;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.ui.activity.shopcar.ConfirmOrderActivity;
import com.melvin.share.view.PurchasePopupWindow;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/25
 * <p>
 * 描述：产品信息
 */
public class ProductInfoActivity extends BaseActivity {
    private ActivityProductInfoBinding binding;
    private Context mContext = null;
    private PurchasePopupWindow menuWindow;
    private boolean flag = true;//true代表购买,false代表加入购物车

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_info);
        mContext = this;
        menuWindow = new PurchasePopupWindow((Activity) mContext, itemsOnClick);
        initWindow();
        initToolbar(binding.toolbar);
        initTable();
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.purchase_confirm:
                    if (flag) {
                        startActivity(new Intent(mContext, ConfirmOrderActivity.class));
                    }
                    break;
            }

        }

    };

    /**
     * 初始化标题,绑定
     */
    private void initTable() {
        ProductInfoAdapter viewPagerAdapter = new ProductInfoAdapter(getSupportFragmentManager(), this);
        binding.viewpager.setAdapter(viewPagerAdapter);//设置适配器
        TabLayout mTabLayout = binding.tablayout;
        mTabLayout.setupWithViewPager(binding.viewpager);
    }

    /**
     * 加入购物车
     *
     * @param v
     */
    public void joinShopCar(View v) {
        flag = false;
        menuWindow.showAtLocation(binding.productInfoRoot, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    /**
     * 立刻购买
     *
     * @param v
     */
    public void purchaseNow(View v) {
        flag = true;
        menuWindow.showAtLocation(binding.productInfoRoot, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }


}


