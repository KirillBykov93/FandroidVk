package com.bykov.kirill.fandroidvk.ui.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bykov.kirill.fandroidvk.MyApplication;
import com.bykov.kirill.fandroidvk.R;


import com.bykov.kirill.fandroidvk.common.manager.BaseAdapter;
import com.bykov.kirill.fandroidvk.common.manager.utils.VkListHelper;
import com.bykov.kirill.fandroidvk.model.WallItem;
import com.bykov.kirill.fandroidvk.model.view.BaseViewModel;
import com.bykov.kirill.fandroidvk.model.view.NewsItemBodyViewModel;
import com.bykov.kirill.fandroidvk.model.view.NewsItemHeaderViewModel;
import com.bykov.kirill.fandroidvk.rest.api.WallApi;
import com.bykov.kirill.fandroidvk.rest.module.response.GetWallResponse;
import com.bykov.kirill.fandroidvk.rest.module.response.request.WallGetRequestModel;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi wallApi;
    RecyclerView recyclerView;
    BaseAdapter adapter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        wallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<GetWallResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                }
                adapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_news_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecView(view);
        setUpAdapter(recyclerView);
    }

    public void setUpRecView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setUpAdapter(RecyclerView recyclerView) {
        adapter = new BaseAdapter();
        recyclerView.setAdapter(adapter);
    }


}
