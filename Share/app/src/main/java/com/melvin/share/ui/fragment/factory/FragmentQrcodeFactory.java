package com.melvin.share.ui.fragment.factory;

import android.support.v4.app.Fragment;

import com.melvin.share.ui.fragment.qrcode.OrderCodeFragment;
import com.melvin.share.ui.fragment.qrcode.ShopCodeFragment;

/**
 * Created Time: 2016/7/21.
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能： 二维码
 */
public class FragmentQrcodeFactory {


    public static Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position == 0) {
            return fragment = new OrderCodeFragment();
        } else
            return fragment = new ShopCodeFragment();
    }

}


