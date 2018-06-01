package com.bykov.kirill.fandroidvk.rest.module.response;

import com.bykov.kirill.fandroidvk.model.Group;
import com.bykov.kirill.fandroidvk.model.Owner;
import com.bykov.kirill.fandroidvk.model.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кирилл on 05.05.2018.
 */

public class ItemWithSendersResponse<T> extends BaseItemResponse<T> {
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    public List<Profile> getProfiles() {
        return profiles;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Owner> getAllSenders() {
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    public Owner getSender(int id) {
        for (Owner owner : getAllSenders()) {
            if (owner.getId() == Math.abs(id)) {
                return owner;
            }
        }
        return null;
    }
}
