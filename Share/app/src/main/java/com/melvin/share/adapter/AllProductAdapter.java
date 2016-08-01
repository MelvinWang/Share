package com.melvin.share.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.melvin.share.R;
import com.melvin.share.databinding.AllProductItemBinding;
import com.melvin.share.databinding.OrderCodeItemBinding;
import com.melvin.share.model.BaseModel;
import com.melvin.share.model.User;
import com.melvin.share.modelview.item.AllProductItemViewModel;
import com.melvin.share.modelview.item.OrderCodeItemViewModel;

import java.util.List;


/**
 * Created Time: 2016/7/25.
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能：商店里的全部商品Adapter
 */
public class AllProductAdapter extends BaseAdapter<AllProductAdapter.BindingHolder> {
    private List<BaseModel> list;
    private Context context;

    public AllProductAdapter(Context context, List<BaseModel> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AllProductItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.all_product_item,
                parent,
                false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bindObject((User) list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Holder
     */
    public class BindingHolder extends RecyclerView.ViewHolder {
        final AllProductItemBinding binding;

        public BindingHolder(AllProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindObject(final User user) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new AllProductItemViewModel(context, user));
            } else {
                binding.getViewModel().setEntity(user);
            }
        }
    }
}



