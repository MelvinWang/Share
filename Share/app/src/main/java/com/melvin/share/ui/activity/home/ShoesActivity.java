package com.melvin.share.ui.activity.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.databinding.ActivityOrnamentBinding;
import com.melvin.share.databinding.ActivityShoesBinding;
import com.melvin.share.modelview.ShoesViewModel;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.view.MyRecyclerView;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/8/4
 * <p/>
 * 描述： 鞋包页面
 */
public class ShoesActivity extends BaseActivity implements MyRecyclerView.LoadingListener {

    private ActivityShoesBinding binding;
    private Context mContext = null;
    private MyRecyclerView mRecyclerView;
    private LinearLayout mRoot;
    private ShoesViewModel shoesViewModel;
    private Map map=new HashMap();
    private String id;
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shoes);
        mContext = this;
        id = getIntent().getStringExtra("id");
        initWindow();
        initToolbar(binding.toolbar);
        ininData();
    }

    private void ininData() {
        map.put("id",id);
        mRoot = binding.root;
        mRecyclerView = binding.recyclerView;
        mRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setLoadingListener(this);
        shoesViewModel = new ShoesViewModel(this, mRecyclerView, mRoot);
        binding.setViewModel(shoesViewModel);
        shoesViewModel.requestData(map);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        shoesViewModel.requestData(map);
        mRecyclerView.refreshComplete();
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {

    }
}
