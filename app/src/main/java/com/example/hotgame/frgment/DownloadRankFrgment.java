package com.example.hotgame.frgment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotgame.R;
import com.example.hotgame.adapter.RanklistAdapter;
import com.example.hotgame.entity.Game;


import java.util.ArrayList;
import java.util.List;

public class DownloadRankFrgment extends Fragment {
    private RecyclerView mRvList;
    private RanklistAdapter rankListAdapter;
    private List<Game> gameList=new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_rank_1, container, false);
        Game a = new Game("王者荣耀","最受欢迎的手机mobi游戏","https://crawl.nosdn.127.net/766e6b23ff78ae349693e3d53ece7c6f.jpg","https://ucan.25pp.com/Wandoujia_web_seo_baidu_homepage.apk");
        gameList.add(a);
        mRvList=view.findViewById(R.id.rv_rank1);

        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置item的分割线
        mRvList.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        rankListAdapter = new RanklistAdapter(getActivity(),mRvList,gameList);
        //RecyclerView设置adapter
        mRvList.setAdapter(rankListAdapter);


        return view;
    }
}
