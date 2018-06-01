package com.bykov.kirill.fandroidvk.model.view;

import android.view.View;

import com.bykov.kirill.fandroidvk.model.WallItem;
import com.bykov.kirill.fandroidvk.ui.holder.BaseViewHolder;
import com.bykov.kirill.fandroidvk.ui.holder.NewsItemHeaderHolder;

/**
 * Created by Кирилл on 05.05.2018.
 */

public class NewsItemHeaderViewModel extends BaseViewModel {
    private int id;
    private String profileName;
    private String profilePhoto;

    private boolean isRepost;
    private String repostProfileName;

    public NewsItemHeaderViewModel(WallItem wallItem) {
        this.id = wallItem.getId();
        this.profileName = wallItem.getSenderName();
        this.profilePhoto = wallItem.getSenderPhoto();
        this.isRepost = wallItem.haveSharedRepost();

        if(isRepost) {
            this.repostProfileName = wallItem.getSharedRepost().senderName;
        }
    }

    @Override
    public LayoutType getType() {
        return LayoutType.NewsFeedItemHeader;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemHeaderHolder(view);
    }

    public int getId() {
        return id;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public boolean isRepost() {
        return isRepost;
    }

    public String getRepostProfileName() {
        return repostProfileName;
    }
}
