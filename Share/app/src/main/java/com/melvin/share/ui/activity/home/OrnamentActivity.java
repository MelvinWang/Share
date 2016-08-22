package com.melvin.share.ui.activity.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.databinding.ActivityFurnitureBinding;
import com.melvin.share.databinding.ActivityOrnamentBinding;
import com.melvin.share.modelview.OrnamentViewModel;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.view.MyRecyclerView;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/8/4
 * <p/>
 * 描述： 饰品页面
 */
public class OrnamentActivity extends BaseActivity implements MyRecyclerView.LoadingListener {

    private ActivityOrnamentBinding binding;
    private Context mContext = null;
    private MyRecyclerView mRecyclerView;
    private LinearLayout mRoot;
    private OrnamentViewModel ornamentViewModel;
    private Map map=new HashMap();
    private String id;
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ornament);
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
        ornamentViewModel = new OrnamentViewModel(this, mRecyclerView, mRoot);
        binding.setViewModel(ornamentViewModel);
        ornamentViewModel.requestData(map);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        ornamentViewModel.requestData(map);
        mRecyclerView.refreshComplete();
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {

    }
}
