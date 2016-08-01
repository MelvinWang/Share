package com.melvin.share.ui.fragment.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.Utils.LogUtils;
import com.melvin.share.Utils.RxBus;
import com.melvin.share.adapter.ShopCarAdapter;
import com.melvin.share.databinding.FragmentShoppingCarBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/17
 * <p>
 * 描述：购物车
 */
public class ShoppingCarFragment extends BaseFragment implements MyRecyclerView.LoadingListener {

    private FragmentShoppingCarBinding binding;
    private Context mContext;
    private MyRecyclerView mRecyclerView;
    private ShopCarAdapter shopCarAdapter;
    private List<BaseModel> data = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping_car, container, false);
        mContext = getActivity();
        LogUtils.i("ShoppingCarFragment+initView");
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
        shopCarAdapter = new ShopCarAdapter(mContext, data);
        mRecyclerView.setAdapter(shopCarAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        RxBus.get().register(this); //注册
        requestData();
    }

    @Override
    public void onStop() {
        super.onStop();
        RxBus.get().unregister(this);//销毁
    }

    //接收一个消息，消息区别是通过参数，因此这里接收一个post事件，参数为字串时，这里就可以收到。
    @Subscribe
    public void eat(String food) {
        Toast.makeText(mContext, food, Toast.LENGTH_SHORT).show();
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
        shopCarAdapter.notifyDataSetChanged();

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
