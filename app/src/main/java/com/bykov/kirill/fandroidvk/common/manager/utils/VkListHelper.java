package com.bykov.kirill.fandroidvk.common.manager.utils;

import com.bykov.kirill.fandroidvk.model.Owner;
import com.bykov.kirill.fandroidvk.model.WallItem;
import com.bykov.kirill.fandroidvk.rest.module.response.ItemWithSendersResponse;

import java.util.List;

/**
 * Created by Кирилл on 09.05.2018.
 */

public class VkListHelper {
    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response) {
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            if(wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());
            }
        }
        return wallItems;
    }
}
