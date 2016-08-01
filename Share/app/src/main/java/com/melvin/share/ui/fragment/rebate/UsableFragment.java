package com.melvin.share.ui.fragment.rebate;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melvin.share.R;
import com.melvin.share.databinding.FragmentUsableBinding;
import com.melvin.share.ui.fragment.main.BaseFragment;

/**
 * Author: Melvin
 * <p/>
 * Data： 2016/7/21
 * <p/>
 * 描述：可用返利
 */
public class UsableFragment extends BaseFragment {

    private FragmentUsableBinding binding;
    private Context mContext;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_usable, container, false);
        mContext = getActivity();
        return binding.getRoot();
    }
}