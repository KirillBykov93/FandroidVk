package com.bykov.kirill.fandroidvk.model.view;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bykov.kirill.fandroidvk.R;
import com.bykov.kirill.fandroidvk.ui.holder.BaseViewHolder;

/**
 * Created by Кирилл on 05.05.2018.
 */

public abstract class BaseViewModel {

    public abstract LayoutType getType();

    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return onCreateViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getType().getValue(), parent, false));
    }

    public abstract BaseViewHolder onCreateViewHolder(View view);

    public enum LayoutType {
        NewsFeedItemHeader(R.layout.item_news_header),
        NewsFeedItemFooter(R.layout.item_news_footer),
        NewsFeedItemBody(R.layout.item_news_body);

        public final int id;

        LayoutType(int resId) {
            this.id = resId;
        }

        @LayoutRes
        public int getValue() {
            return id;
        }
    }
}
