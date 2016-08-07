package com.melvin.share.ui.activity.shopcar;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.Utils.LogUtils;
import com.melvin.share.Utils.RxBus;
import com.melvin.share.adapter.ShopCarAdapter;
import com.melvin.share.databinding.ActivityShoppingCarEditBinding;
import com.melvin.share.databinding.FragmentShoppingCarBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.modelview.ShopCarEditViewModel;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

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
