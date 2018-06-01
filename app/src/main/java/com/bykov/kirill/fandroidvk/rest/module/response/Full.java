package com.bykov.kirill.fandroidvk.rest.module.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Кирилл on 23.04.2018.
 */

public class Full<T> {
    @SerializedName("response")
    @Expose
    public T response;
}
