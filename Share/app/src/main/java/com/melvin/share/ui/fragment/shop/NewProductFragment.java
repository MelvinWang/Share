package com.melvin.share.ui.fragment.shop;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.adapter.NewProductAdapter;
import com.melvin.share.databinding.FragmentNewProductBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.ui.fragment.main.BaseFragment;
import com.melvin.share.view.NoRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/25
 * <p>
 * 描述：新品上架
 */
public class NewProductFragment extends BaseFragment implements NoRefreshRecyclerView.LoadingListener {

    private FragmentNewProductBinding binding;
    private Context mContext;
    private NoRefreshRecyclerView mRecyclerView;
    private NewProductAdapter newProductAdapter;
    private List<BaseModel> data = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_prodcut, container, false);
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
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setLoadingListener(this);
    }

    /**
     * 初始化Adapter
     */
    private void initAdapter() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        newProductAdapter = new NewProductAdapter(mContext, data);
        mRecyclerView.setAdapter(newProductAdapter);
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
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.password = i + "";
            user.username = i + "";
            list.add(user);
        }
        data.addAll(list);
        newProductAdapter.notifyDataSetChanged();

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