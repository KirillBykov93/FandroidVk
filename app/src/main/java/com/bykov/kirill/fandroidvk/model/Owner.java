package com.bykov.kirill.fandroidvk.model;

import com.vk.sdk.api.model.Identifiable;

/**
 * Created by Кирилл on 05.05.2018.
 */

public interface Owner extends Identifiable {

    String getFullName();
    String getPhoto();
}
