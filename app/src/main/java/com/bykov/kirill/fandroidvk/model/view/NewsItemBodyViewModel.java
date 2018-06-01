package com.bykov.kirill.fandroidvk.model.view;

import android.view.View;

import com.bykov.kirill.fandroidvk.model.WallItem;
import com.bykov.kirill.fandroidvk.ui.holder.BaseViewHolder;
import com.bykov.kirill.fandroidvk.ui.holder.NewsItemBodyViewHolder;

/**
 * Created by Кирилл on 05.05.2018.
 */

public class NewsItemBodyViewModel extends BaseViewModel {
    private String text;
    private int id;

    public NewsItemBodyViewModel(WallItem wallItem) {
        this.id = wallItem.getId();
        this.text = wallItem.getText();
    }

    @Override
    public LayoutType getType() {
        return LayoutType.NewsFeedItemBody;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyViewHolder(view);
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
