package com.bykov.kirill.fandroidvk.common.manager;



import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import com.bykov.kirill.fandroidvk.ui.activity.BaseActivity;
import com.bykov.kirill.fandroidvk.ui.fragment.BaseFragment;

import java.util.Stack;

/**
 * Created by Кирилл on 19.04.2018.
 */

public class MyFragmentManager {
    private static final int EMPTY_FRAGMENT_SIZE = 1;

    private Stack<BaseFragment> fragmentStack = new Stack<>();

    private BaseFragment currentFragment;

    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if(activity != null && !activity.isFinishing() && !isAllReadyContains(fragment)) {
            FragmentTransaction transaction = createAddTransaction(activity, fragment, false);
                transaction.replace(containerId, fragment);
                commitAddTransaction(activity, fragment, transaction, false);
            }
        }

    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if(activity != null && !activity.isFinishing() && !isAllReadyContains(fragment)) {
            FragmentTransaction transaction = createAddTransaction(activity, fragment, true);
            transaction.replace(containerId, fragment);
            commitAddTransaction(activity, fragment, transaction, true);
        }
    }

    public boolean removeCurrentFragment(BaseActivity activity) {
        return removeFragment(activity, currentFragment);
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment) {
        boolean canRemove = currentFragment != null && fragmentStack.size() > EMPTY_FRAGMENT_SIZE;

        if(canRemove) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentStack.pop();
            currentFragment = fragmentStack.lastElement();
            transaction.remove(fragment);
            commitTransaction(activity, transaction);
        }
        return canRemove;
    }


    private FragmentTransaction createAddTransaction(BaseActivity activity, BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        if(addToBackStack) {
            transaction.addToBackStack(fragment.getTag());
        }

        return transaction;
    }

    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction transaction, boolean addToBackStack) {

        if(transaction != null) {
            currentFragment = fragment;
        }

        if (!addToBackStack) {
            fragmentStack = new Stack<>();
        }

        fragmentStack.add(fragment);
        commitTransaction(activity, transaction);
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction) {
        transaction.commit();
        activity.fragmentOnScreen(currentFragment);
    }

    public boolean isAllReadyContains(BaseFragment fragment) {
        if(fragment == null) {
            return false;
        }
        return currentFragment != null && currentFragment.getClass().getName().equals(fragment.getClass().getName());
    }
}
