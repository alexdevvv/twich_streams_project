package com.example.twichstreams.view.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.twichstreams.R;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.model.twitch_responce.Top;

import java.util.ArrayList;
import java.util.List;

public class TwitchGamesAdapter extends RecyclerView.Adapter<GameViewHolder> {
    private List<GameDataModel> list;

    public TwitchGamesAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item_view, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        GameDataModel gameDataModel = list.get(position);
        holder.setView(gameDataModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   public void setData(List<GameDataModel> gameDataList) {
        list = gameDataList;
        notifyDataSetChanged();
    }
}
