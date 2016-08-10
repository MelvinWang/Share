package com.melvin.share.ui.fragment.productinfo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allure.lbanners.LMBanners;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.adapter.ProductInformationAdapter;
import com.melvin.share.adapter.UrlImgAdapter;
import com.melvin.share.databinding.FragmentProductinfoBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.ui.fragment.main.BaseFragment;
import com.melvin.share.view.MyRecyclerView;
import com.melvin.share.view.NoRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/7/25
 * <p/>
 * 描述：单个商品详细信息
 */
public class ProductInfoFragment extends BaseFragment implements NoRefreshRecyclerView.LoadingListener {
    private FragmentProductinfoBinding binding;
    private Context mContext;
    private LMBanners mLBanners;
    private NoRefreshRecyclerView mRecyclerView;
    private ProductInformationAdapter productInformationAdapter;
    private List<BaseModel> data = new ArrayList<>();
    //本地图片
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    //网络图片
    private List<String> networkImages = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_productinfo, container, false);
        mContext = getActivity();
        mLBanners = binding.banners;
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

    @Override
    public void onStart() {
        super.onStart();
        addLocalImg();
        addUrilImg();
        //本地用法
//        mLBanners.setAdapter(new LocalImgAdapter(mContext), localImages);
        //网络图片
        mLBanners.setAdapter(new UrlImgAdapter(mContext), networkImages);
        requestData();
    }

    /**
     * 初始化Adapter
     */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        productInformationAdapter = new ProductInformationAdapter(mContext, data);
        mRecyclerView.setAdapter(productInformationAdapter);
    }

    /**
     * 请求网络
     */
    private void requestData() {
        List list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.password = i+"";
            user.username = i+"";
            list.add(user);
        }
        data.addAll(list);
        productInformationAdapter.notifyDataSetChanged();

    }



    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {
        requestData();
        mRecyclerView.loadMoreComplete();
    }


    private void addUrilImg() {
        networkImages.clear();
        networkImages.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=ff62800b073b5bb5a1d726fe06d2d523/a6efce1b9d16fdfa7807474eb08f8c5494ee7b23.jpg");
        networkImages.add("http://g.hiphotos.baidu.com/image/h%3D300/sign=0a9ac84f89b1cb1321693a13ed5556da/1ad5ad6eddc451dabff9af4bb2fd5266d0163206.jpg");
        networkImages.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=61660ec2207f9e2f6f351b082f31e962/500fd9f9d72a6059e5c05d3e2f34349b023bbac6.jpg");
        networkImages.add("http://c.hiphotos.baidu.com/image/h%3D300/sign=f840688728738bd4db21b431918a876c/f7246b600c338744c90c3826570fd9f9d62aa09a.jpg");

    }

    private void addLocalImg() {
        localImages.clear();
        localImages.add(R.mipmap.ic_launcher);
        localImages.add(R.mipmap.ic_launcher);
        localImages.add(R.mipmap.ic_launcher);
        localImages.add(R.mipmap.ic_launcher);
        localImages.add(R.mipmap.ic_launcher);
    }

    @Override
    public void onPause() {
        super.onPause();
        mLBanners.stopImageTimerTask();
    }

    @Override
    public void onResume() {
        super.onResume();
        mLBanners.startImageTimerTask();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLBanners.clearImageTimerTask();
    }
}