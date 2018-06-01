package com.bykov.kirill.fandroidvk.rest.module.response.request;

import com.bykov.kirill.fandroidvk.consts.ApiConstants;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.Map;

/**
 * Created by Кирилл on 23.04.2018.
 */

public class WallGetRequestModel extends BaseRequestModel {

    @SerializedName(VKApiConst.OWNER_ID)
    int ownerId;

    @SerializedName(VKApiConst.COUNT)
    int count = ApiConstants.DEFAULT_COUNT;

    @SerializedName(VKApiConst.OFFSET)
    int offSet;

    @SerializedName(VKApiConst.EXTENDED)
    int extended = 1;

    public WallGetRequestModel(int ownerId) {
        this.ownerId = ownerId;
    }

    public WallGetRequestModel(int ownerId, int count, int offSet) {
        this.ownerId = ownerId;
        this.offSet = offSet;
        this.count = count;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public int getExtended() {
        return extended;
    }

    public void setExtended(int extended) {
        this.extended = extended;
    }

    @Override
    public void onMapCreate(Map<String, String> map) {
        map.put(VKApiConst.OWNER_ID, String.valueOf(getOwnerId()));
        map.put(VKApiConst.COUNT, String.valueOf(getCount()));
        map.put(VKApiConst.OFFSET, String.valueOf(getOffSet()));
        map.put(VKApiConst.EXTENDED, String.valueOf(getExtended()));
    }
}
