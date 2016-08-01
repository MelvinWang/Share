package com.melvin.share.modelview;

import android.content.Context;
import android.widget.LinearLayout;

import com.melvin.share.adapter.ManageAddressAdapter;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.view.MyRecyclerView;
import com.melvin.share.view.RequestView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Melvin
 * <p>
 * Data： 2016/7/24
 * <p>
 * 描述： 管理收货地址ViewModel
 */
public class ManageAddressViewModel extends BaseRecyclerViewModel<BaseModel> implements RequestView<BaseModel> {

    private ManageAddressAdapter adapter;
    private Context context;
    private MyRecyclerView mRecyclerView;
    public List<BaseModel> data = new ArrayList<>();

    public ManageAddressViewModel(Context context, MyRecyclerView mRecyclerView, LinearLayout mRoot) {
        super(context, mRoot);
        this.context = context;
        this.mRecyclerView = mRecyclerView;
        adapter = new ManageAddressAdapter(context, getData());

    }

    public void requestData() {
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

        onRequestSuccess(data);
    }


    public void requestQueryData(Map map) {
    }

    public ManageAddressAdapter getAdapter() {
        return adapter;
    }

}
