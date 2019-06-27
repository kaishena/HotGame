package com.example.hotgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.hotgame.R;
import com.example.hotgame.activity.DownloadActivity;
import com.example.hotgame.activity.GameActivity;
import com.example.hotgame.entity.Game;

import java.util.List;


public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {
    private Context mContext;
    private View mItemView;
    private  RecyclerView mRv;
    private List<Game> mGamelist;
    private View game_layout;

    public GameListAdapter(Context context, RecyclerView recyclerView,List<Game> gameList)
    {
        mContext=context;
        mRv=recyclerView;
        mGamelist=gameList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemView=LayoutInflater.from(mContext).inflate(R.layout.item_list_game,parent,false);
        return new ViewHolder(mItemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
         final Game game=mGamelist.get(position);
         holder.game_name.setText(game.getName());
         holder.game_introduction.setText(game.getIntroduction());
         Glide.with(mContext)
                .load(game.getImageSource())
                .into(holder.iv_game);
         holder.game_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(mContext, GameActivity.class);
                 Bundle bundle=new Bundle();
                 bundle.putString("name",game.getName());
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
        TextView game_name,game_introduction;
        ImageView iv_game;
        View game_layout;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);
           game_name= itemView.findViewById(R.id.game_name);
           game_introduction=itemView.findViewById(R.id.game_introduction);
           iv_game=itemView.findViewById(R.id.iv_game);
           game_layout=itemView.findViewById(R.id.layout_game);

        }
    }
}
