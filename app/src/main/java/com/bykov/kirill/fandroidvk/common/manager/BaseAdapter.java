package com.bykov.kirill.fandroidvk.common.manager;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.ViewGroup;

import com.bykov.kirill.fandroidvk.model.view.BaseViewModel;
import com.bykov.kirill.fandroidvk.ui.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кирилл on 05.05.2018.
 */

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {
    public List<BaseViewModel> list = new ArrayList<>();

    public ArrayMap<Integer, BaseViewModel> typeInstances = new ArrayMap<>();

    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return typeInstances.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));

    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void registerTypeInstances(BaseViewModel item) {
        if (!typeInstances.containsKey(item.getType().getValue())) {
            typeInstances.put(item.getType().getValue(), item);
        }
    }

    public void addItems(List<? extends BaseViewModel> newItems) {
        for (BaseViewModel newItem : newItems) {
            registerTypeInstances(newItem);
        }

        list.addAll(newItems);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    public BaseViewModel getItem(int position) {
        return list.get(position);
    }

    public void setItems(BaseViewModel items) {
        clearItems();
        list.add(items);
    }

    public void clearItems() {
        list.clear();
    }
}
