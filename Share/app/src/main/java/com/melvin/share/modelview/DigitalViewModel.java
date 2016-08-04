package com.melvin.share.modelview;

import android.content.Context;
import android.widget.LinearLayout;

import com.melvin.share.adapter.ClothAdapter;
import com.melvin.share.adapter.DigitalAdapter;
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
 * Data： 2016/8/4
 * <p>
 * 描述： 数码页面ViewModel
 */
public class DigitalViewModel extends BaseRecyclerViewModel<BaseModel> implements RequestView<BaseModel> {

    private DigitalAdapter adapter;
    private Context context;
    private MyRecyclerView mRecyclerView;
    public List<BaseModel> data = new ArrayList<>();

    public DigitalViewModel(Context context, MyRecyclerView mRecyclerView, LinearLayout mRoot) {
        super(context, mRoot);
        this.context = context;
        this.mRecyclerView = mRecyclerView;
        adapter = new DigitalAdapter(context, getData());

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

    public DigitalAdapter getAdapter() {
        return adapter;
    }

}
