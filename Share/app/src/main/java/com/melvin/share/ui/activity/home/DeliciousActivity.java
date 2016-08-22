package com.melvin.share.ui.activity.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.melvin.share.R;
import com.melvin.share.Utils.Utils;
import com.melvin.share.databinding.ActivityDeliciousBinding;
import com.melvin.share.modelview.DeliciousViewModel;
import com.melvin.share.ui.activity.common.BaseActivity;
import com.melvin.share.view.MyRecyclerView;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/8/4
 * <p/>
 * 描述： 餐饮页面
 */
public class DeliciousActivity extends BaseActivity implements MyRecyclerView.LoadingListener {

    private ActivityDeliciousBinding binding;
    private Context mContext = null;
    private MyRecyclerView mRecyclerView;
    private LinearLayout mRoot;
    private DeliciousViewModel deliciousViewModel;
    private Map map = new HashMap();
    private boolean priceClicked = false;//false代表价格向下查询，true代表价格向上查询
    private String id;
    RadioGroup mRadioGroup;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_delicious);
        mContext = this;
        id = getIntent().getStringExtra("id");
        initWindow();
        initToolbar(binding.toolbar);
        ininData();
    }

    private void ininData() {
        map.put("id", id);
        mRoot = binding.root;
        mRadioGroup = binding.mRadioGroup;
        //设置选项选中事件
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                priceClicked = false;
                binding.price.setImageResource(R.mipmap.normal_price);
                switch (checkedId) {
                    case R.id.level:
                        Utils.showToast(mContext, "level");
                        break;
                    case R.id.sale_total:
                        Utils.showToast(mContext, "sale_total");
                        break;
                    case R.id.share_times:
                        Utils.showToast(mContext, "share_times");
                        break;
                }
            }
        });

        mRecyclerView = binding.recyclerView;
        mRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setLoadingListener(this);
        deliciousViewModel = new DeliciousViewModel(this, mRecyclerView, mRoot);
        binding.setViewModel(deliciousViewModel);
        deliciousViewModel.requestData(map);
    }

    /**
     * 价格查询
     *
     * @param v
     */
    public void priceQuery(View v) {
        mRadioGroup.clearCheck();
        priceClicked = !priceClicked;
        if (priceClicked) {
            binding.price.setImageResource(R.mipmap.price_up);
            Utils.showToast(mContext, "价格从高到低");
        } else {
            binding.price.setImageResource(R.mipmap.price_down);
            Utils.showToast(mContext, "价格从低到高");
        }
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        deliciousViewModel.requestData(map);
        mRecyclerView.refreshComplete();
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {

    }
}
