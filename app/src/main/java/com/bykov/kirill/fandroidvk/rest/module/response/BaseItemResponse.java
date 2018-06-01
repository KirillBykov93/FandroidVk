package com.bykov.kirill.fandroidvk.rest.module.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кирилл on 23.04.2018.
 */

public class BaseItemResponse<T> {
    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}
