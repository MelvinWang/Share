package com.melvin.share.ui.fragment.qrcode;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.adapter.OrderCodeAdapter;
import com.melvin.share.adapter.ShopCodeAdapter;
import com.melvin.share.databinding.FragmentShopCodeBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.ui.fragment.main.BaseFragment;
import com.melvin.share.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/21
 * <p>
 * 描述：店铺二维码
 */
public class ShopCodeFragment extends BaseFragment implements MyRecyclerView.LoadingListener {

    private FragmentShopCodeBinding binding;
    private Context mContext;
    private MyRecyclerView mRecyclerView;
    private ShopCodeAdapter orderCodeAdapter;
    private List<BaseModel> data = new ArrayList<>();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop_code, container, false);
        mContext = getActivity();
        initData();
        initAdapter();
        return binding.getRoot();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mRecyclerView = binding.recyclerView;
        mRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setLoadingListener(this);
    }

    /**
     * 初始化Adapter
     */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        orderCodeAdapter = new ShopCodeAdapter(mContext, data);
        mRecyclerView.setAdapter(orderCodeAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        requestData();
    }

    /**
     * 请求网络
     */
    private void requestData() {
        List list = new ArrayList<>();
        User user = new User();
        user.password = "1";
        user.username = "2";
        list.add(user);
        User user1 = new User();
        user1.password = "3";
        user1.username = "4";
        list.add(user1);
        data.addAll(list);
        orderCodeAdapter.notifyDataSetChanged();

    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        data.clear();
        requestData();
        mRecyclerView.refreshComplete();

    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {
        requestData();
        mRecyclerView.loadMoreComplete();
    }
}
