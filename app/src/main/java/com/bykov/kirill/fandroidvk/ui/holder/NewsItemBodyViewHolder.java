package com.bykov.kirill.fandroidvk.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.bykov.kirill.fandroidvk.R;
import com.bykov.kirill.fandroidvk.model.view.NewsItemBodyViewModel;

/**
 * Created by Кирилл on 05.05.2018.
 */

public class NewsItemBodyViewHolder extends BaseViewHolder<NewsItemBodyViewModel> {
    private TextView textView;

    public NewsItemBodyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel newsFeedItemBodyViewModel) {
        textView.setText(newsFeedItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
        textView.setText(null);
    }
}
