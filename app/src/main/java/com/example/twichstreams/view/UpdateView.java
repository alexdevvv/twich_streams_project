package com.example.twichstreams.view;

import com.example.twichstreams.model.twitch_responce.GameDataModel;

import java.util.List;

public interface UpdateView {

    void updateViewMethod(List<GameDataModel> gameDataModelsList);
}
