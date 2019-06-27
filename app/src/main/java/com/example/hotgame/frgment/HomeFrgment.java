package com.example.hotgame.frgment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotgame.R;
import com.example.hotgame.activity.BaseActivity;
import com.example.hotgame.activity.MainActivity;
import com.example.hotgame.adapter.GameListAdapter;
import com.example.hotgame.entity.Game;


import java.util.ArrayList;
import java.util.List;

public class HomeFrgment extends Fragment {
    private RecyclerView mRvList;
    private GameListAdapter gameListAdapter;
    private List<Game> gameList=new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_home, container, false);



        Game a = new Game("王者荣耀","最受欢迎的手机mobi游戏","https://crawl.nosdn.127.net/766e6b23ff78ae349693e3d53ece7c6f.jpg","http://apk.apk.xgdown.com/down/zhuishushenqi.apk");
        gameList.add(a);


        mRvList=view.findViewById(R.id.rv_game);

        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置item的分割线
        mRvList.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        gameListAdapter = new GameListAdapter(getActivity(),mRvList,gameList);
        //RecyclerView设置adapter
        mRvList.setAdapter(gameListAdapter);



        return view;
    }



}
