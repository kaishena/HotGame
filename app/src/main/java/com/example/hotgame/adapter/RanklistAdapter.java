package com.example.hotgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotgame.R;
import com.example.hotgame.activity.DownloadActivity;
import com.example.hotgame.entity.Game;

import java.util.List;

public class RanklistAdapter extends RecyclerView.Adapter<RanklistAdapter.ViewHolder> {
    private Context mContext;
    private View mItemView;
    private  RecyclerView mRv;
    private List<Game> mGamelist;

    public RanklistAdapter(Context context, RecyclerView recyclerView, List<Game> gamelist)
    {
        mContext=context;
        mRv=recyclerView;
        mGamelist=gamelist;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemView= LayoutInflater.from(mContext).inflate(R.layout.item_list_rank,parent,false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Game game=mGamelist.get(position);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, DownloadActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("downloadUrl",game.getDownloadUrl());
                intent.putExtras(bundle);
                mContext.startActivity(intent);


            }
        });







    }

    @Override
    public int getItemCount() {
        return mGamelist.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private Button btn;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            btn=itemView.findViewById(R.id.btn_download);

        }
    }

}