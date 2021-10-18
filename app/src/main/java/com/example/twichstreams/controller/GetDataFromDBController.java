package com.example.twichstreams.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.twichstreams.model.room.AppDatabase;
import com.example.twichstreams.model.room.GameDataTable;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.view.UpdateView;
import com.example.twichstreams.view.recycler_view.TwitchGamesAdapter;

import java.util.ArrayList;
import java.util.List;

public class GetDataFromDBController extends GetDataController {
    private AppDatabase appDatabase;

    @Override
    public List<GameDataModel> getData(UpdateView updateView) {
        return null;
    }

    public void saveData(Context context, List<GameDataModel> gameDataModelsList) {
        appDatabase = AppDatabase.getInstance(context);
        new SaveDataTask().execute(gameDataModelsList);

    }

    class SaveDataTask extends AsyncTask<List<GameDataModel>, Void, Void> {
        @Override
        protected Void doInBackground(List<GameDataModel>... gameDataViewModelList) {
                List<GameDataTable> gameDataTableList = new ArrayList<>();
            for (GameDataModel gameDataModel : gameDataViewModelList[0]) {
                GameDataTable gameDataTable = new GameDataTable(gameDataModel.getName(), gameDataModel.getViewers(), gameDataModel.getChannels(), gameDataModel.getLogo());
                gameDataTableList.add(gameDataTable);
            }
            return null;
        }
    }
}



