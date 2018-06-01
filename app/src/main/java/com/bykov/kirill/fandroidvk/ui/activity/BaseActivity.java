package com.bykov.kirill.fandroidvk.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.bykov.kirill.fandroidvk.MyApplication;
import com.bykov.kirill.fandroidvk.R;
import com.bykov.kirill.fandroidvk.common.manager.MyFragmentManager;
import com.bykov.kirill.fandroidvk.ui.fragment.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Кирилл on 14.04.2018.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        MyApplication.getApplicationComponent().inject(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();


    public void fragmentOnScreen(BaseFragment fragment) {
        setToolbarTitle(fragment.createToolbarTitle(this));

    }

    public void setToolbarTitle(String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


    public void setContent(BaseFragment fragment) {
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public void removeContent(BaseFragment fragment) {
        myFragmentManager.removeFragment(this, fragment);
    }

    public void removeCurrentFragment() {
        myFragmentManager.removeCurrentFragment(this);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
