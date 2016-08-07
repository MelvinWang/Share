package com.melvin.share.ui.activity.selfcenter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.databinding.ActivityWaitReceiveProdOrderInfoBinding;
import com.melvin.share.databinding.ActivityWaitSendProdOrderInfoBinding;
import com.melvin.share.modelview.WaitReceiveProOrderInfoViewModel;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.view.MyRecyclerView;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/8/7
 * <p/>
 * 描述： 待收货订单信息
 */
public class WaitReceiveProductOrderInformationActivity extends BaseActivity implements MyRecyclerView.LoadingListener {

    private ActivityWaitReceiveProdOrderInfoBinding binding;
    private Context mContext = null;
    private MyRecyclerView mRecyclerView;
    private LinearLayout mRoot;
    private WaitReceiveProOrderInfoViewModel waitReceiveProOrderInfoViewModel;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wait_receivepro_order_info);
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
        waitReceiveProOrderInfoViewModel = new WaitReceiveProOrderInfoViewModel(this, mRecyclerView, mRoot);
        binding.setViewModel(waitReceiveProOrderInfoViewModel);
        waitReceiveProOrderInfoViewModel.requestData();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        waitReceiveProOrderInfoViewModel.requestData();
        mRecyclerView.refreshComplete();
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {

    }
}
