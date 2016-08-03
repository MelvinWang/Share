package com.melvin.share.ui.fragment.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allure.lbanners.LMBanners;
import com.melvin.share.R;
import com.melvin.share.Utils.LogUtils;
import com.melvin.share.Utils.Utils;
import com.melvin.share.adapter.HomeProductAdapter;
import com.melvin.share.adapter.HomeShopAdapter;
import com.melvin.share.adapter.LocalImgAdapter;
import com.melvin.share.databinding.FragmentHomeBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.ui.activity.SearchActivity;
import com.melvin.share.ui.activity.common.MainActivity;
import com.melvin.share.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/17
 * <p>
 * 描述：首页
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    private Context mContext;
    private LMBanners mLBanners;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private List<String> networkImages = new ArrayList<>();
    private HomeProductAdapter newProductAdapter;
    private HomeProductAdapter userRecommendProductAdapter;
    private HomeShopAdapter shopAdapter;

    private List<BaseModel> data1 = new ArrayList<>();
    private List<BaseModel> data2 = new ArrayList<>();
    private List<BaseModel> data3 = new ArrayList<>();
    private RecyclerView newRecyclerView;
    private RecyclerView userRecommendRecyclerView;
    private RecyclerView shopRecyclerView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        mContext = getActivity();
        mLBanners = binding.banners;
        initClick();
        initData();
        initAdapter();
        LogUtils.i("HomeFragment+initView");
        return binding.getRoot();
    }

    /**
     * 初始化点击事件
     */
    private void initClick() {
        binding.homeScan.setOnClickListener(this);
        binding.searchEnter.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_scan:
                Intent openCameraIntent = new Intent(mContext, CaptureActivity.class);
                startActivityForResult(openCameraIntent, 0);
                break;
            case R.id.search_enter:
                startActivity(new Intent(mContext, SearchActivity.class));
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ((Activity) mContext).RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Utils.showToast(mContext, scanResult);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        addLocalImg();
        addUrilImg();
        //本地用法
        mLBanners.setAdapter(new LocalImgAdapter(mContext), localImages);
        //网络图片
//        mLBanners.setAdapter(new UrlImgAdapter(MainActivity.this), networkImages);
        requestData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
        newRecyclerView = binding.newRecyclerView;
        userRecommendRecyclerView = binding.userRecommendRecyclerView;
        shopRecyclerView = binding.shopRecyclerView;

    }


    /**
     * 初始化Adapter
     */
    private void initAdapter() {
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(mContext, 4);
        gridLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        newRecyclerView.setLayoutManager(gridLayoutManager1);
        newProductAdapter = new HomeProductAdapter(mContext, data1);
        newRecyclerView.setAdapter(newProductAdapter);

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(mContext, 4);
        gridLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        userRecommendRecyclerView.setLayoutManager(gridLayoutManager2);
        userRecommendProductAdapter = new HomeProductAdapter(mContext, data2);
        userRecommendRecyclerView.setAdapter(userRecommendProductAdapter);

        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(mContext, 4);
        gridLayoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
        shopRecyclerView.setLayoutManager(gridLayoutManager3);
        shopAdapter = new HomeShopAdapter(mContext, data3);
        shopRecyclerView.setAdapter(shopAdapter);
    }

    /**
     * 请求网络
     */
    private void requestData() {
        List list = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            User user = new User();
            user.password = "1";
            user.username = "2";
            list.add(user);
        }
        data1.addAll(list);
        data2.addAll(list);
        data3.addAll(list);
        newProductAdapter.notifyDataSetChanged();
        userRecommendProductAdapter.notifyDataSetChanged();
        shopAdapter.notifyDataSetChanged();

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