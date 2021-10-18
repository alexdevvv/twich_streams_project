package com.example.twichstreams.view.recycler_view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.twichstreams.R;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.model.twitch_responce.Top;
import com.squareup.picasso.Picasso;

public class GameViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewGameLogo;
    TextView textViewGameName;
    TextView textViewNumberChannels;
    TextView textViewNumberViewers;
    public GameViewHolder(View itemView) {
        super(itemView);
        textViewGameName = itemView.findViewById(R.id.game_name_tv);
        textViewNumberChannels = itemView.findViewById(R.id.number_channels_tv);
        textViewNumberViewers = itemView.findViewById(R.id.number_viewers_tv);
        imageViewGameLogo = itemView.findViewById(R.id.game_logo_iv);
    }

    public void setView(GameDataModel gameDataModel) {
        textViewGameName.setText( "Game name: " + gameDataModel.getName());
        textViewNumberViewers.setText("Number viewers: " + gameDataModel.getViewers() + "");
        textViewNumberChannels.setText("Number channels: " + gameDataModel.getChannels() + "");
        Picasso.with(itemView.getContext())
                .load(gameDataModel.getLogo())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageViewGameLogo);
    }
}
