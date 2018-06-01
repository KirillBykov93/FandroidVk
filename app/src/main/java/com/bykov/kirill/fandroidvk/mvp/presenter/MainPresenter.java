package com.bykov.kirill.fandroidvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bykov.kirill.fandroidvk.CurrentUser;
import com.bykov.kirill.fandroidvk.mvp.view.MainView;

/**
 * Created by Кирилл on 14.04.2018.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if(!CurrentUser.isAuthorized()) {
            getViewState().StartSignIn();
        }else {
            getViewState().signedId();
        }
    }
}
