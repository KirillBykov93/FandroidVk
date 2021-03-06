package com.bykov.kirill.fandroidvk.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bykov.kirill.fandroidvk.model.view.BaseViewModel;

/**
 * Created by Кирилл on 05.05.2018.
 */

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unbindViewHolder();
}
