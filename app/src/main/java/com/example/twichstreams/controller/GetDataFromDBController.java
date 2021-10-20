package com.example.twichstreams.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.example.twichstreams.model.room.AppDatabase;
import com.example.twichstreams.model.room.GameDataTable;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.view.UpdateView;

import java.util.ArrayList;
import java.util.List;

public class GetDataFromDBController extends GetDataController {

    private AppDatabase appDatabase;
    private List<GameDataTable> gameDataTableList;
    private List<GameDataModel> gameDataModelList;

    @Override
    public List<GameDataModel> getData(UpdateView updateView, Context context) {

        appDatabase = AppDatabase.getInstance(context);
        new GetDataFromDB(updateView).execute();
        return null;
    }

    private List<GameDataModel> parseDataFromDB(List<GameDataTable> list) {
        List<GameDataModel> listGameDataModel = new ArrayList<>();
        for (GameDataTable gameDataTableSubject : list) {
            listGameDataModel.add(new GameDataModel(
                    gameDataTableSubject.getName(),
                    gameDataTableSubject.getViewers(),
                    gameDataTableSubject.getChannels(),
                    gameDataTableSubject.getLogo()
            ));
        }
        return listGameDataModel;
    }

    private class GetDataFromDB extends AsyncTask<Void, Void, List<GameDataModel>> {

        private UpdateView updateView;

        GetDataFromDB(UpdateView updateView) {
            this.updateView = updateView;
        }

        @Override
        protected List<GameDataModel> doInBackground(Void... voids) {
            gameDataModelList = new ArrayList<>();
            gameDataTableList = appDatabase.gameDataDao().getAll();
            gameDataModelList = parseDataFromDB(gameDataTableList);
            return gameDataModelList;
        }

        @Override
        protected void onPostExecute(List<GameDataModel> gameDataModelList) {
            updateView.updateViewMethod(gameDataModelList);
        }

    }


}



