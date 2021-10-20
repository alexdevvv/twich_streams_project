package com.example.twichstreams.controller;

import android.content.Context;

import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.view.UpdateView;
import com.example.twichstreams.view.recycler_view.TwitchGamesAdapter;

import java.util.List;

public abstract class GetDataController {
    public abstract List<GameDataModel> getData(UpdateView updateView, Context context);
}
