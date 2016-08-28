package com.melvin.share.ui.activity.shopcar;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.databinding.ActivityShoppingCarEditBinding;
import com.melvin.share.modelview.acti.ShopCarEditViewModel;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.view.MyRecyclerView;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/8/7
 * <p>
 * 描述：购物车编辑
 */
public class ShoppingCarEditActivity extends BaseActivity implements MyRecyclerView.LoadingListener {

    private ActivityShoppingCarEditBinding binding;
    private Context mContext;
    private MyRecyclerView mRecyclerView;
    private LinearLayout mRoot;
    private ShopCarEditViewModel shopCarEditViewModel;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_car_edit);
        mContext = this;
        initWindow();
        initToolbar(binding.toolbar);
        ininData();
    }

    private void ininData() {
        mRoot = binding.root;
        mRecyclerView = binding.recyclerView;
        mRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setLoadingListener(this);
        shopCarEditViewModel = new ShopCarEditViewModel(this, mRecyclerView, mRoot);
        binding.setViewModel(shopCarEditViewModel);
        shopCarEditViewModel.requestData();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        shopCarEditViewModel.requestData();
        mRecyclerView.refreshComplete();
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {

    }


}
