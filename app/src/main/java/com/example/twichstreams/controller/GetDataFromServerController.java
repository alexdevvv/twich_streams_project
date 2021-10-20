package com.example.twichstreams.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.twichstreams.model.room.AppDatabase;
import com.example.twichstreams.model.room.GameDataTable;
import com.example.twichstreams.model.twitch_responce.API;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.model.twitch_responce.RetrofitKeeper;
import com.example.twichstreams.model.twitch_responce.Top;
import com.example.twichstreams.model.twitch_responce.TwitchResponseMain;
import com.example.twichstreams.model.twitch_responce.TwitchStreamApi;
import com.example.twichstreams.view.UpdateView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetDataFromServerController extends GetDataController {

    AppDatabase appDatabase;
    public boolean internetConnect = false;

    @Override
   public List<GameDataModel> getData(UpdateView updateView, Context context) {
        Retrofit retrofit = RetrofitKeeper.getInstance();
        TwitchStreamApi twitchStreamApi = retrofit.create(TwitchStreamApi.class);

        Call<TwitchResponseMain> callTwitch = twitchStreamApi.getTwitchStream(API.accept, API.client_id);
        callTwitch.enqueue(new Callback<TwitchResponseMain>() {

            @Override
            public void onResponse(Call<TwitchResponseMain> call, Response<TwitchResponseMain> response) {
                List<Top> listTop = new ArrayList<>();
                if (response.isSuccessful()) {
                    listTop = response.body().getTop();
                    internetConnect = true;
                    List<GameDataModel> gameDataModelList = parseDataFromServer(listTop);
                    updateView.updateViewMethod(gameDataModelList);
                    appDatabase = AppDatabase.getInstance(context);
                    new SaveDataTask().execute(gameDataModelList);
                }
            }

            @Override
            public void onFailure(Call<TwitchResponseMain> call, Throwable t) {
                Log.i("errorOnFailure", t.getMessage());
            }
        });

        return null;
    }

    public boolean getInternetConnect() {
        return internetConnect;
    }

    private List<GameDataModel> parseDataFromServer(List<Top> list) {
        List<GameDataModel> listGameData = new ArrayList<>();
        for (Top top : list) {
            listGameData.add(GameDataModel.getGameDataModelFromTop(top));
        }
        return listGameData;
    }




    class SaveDataTask extends AsyncTask<List<GameDataModel>, Void, Void> {
        @Override
        protected Void doInBackground(List<GameDataModel>... gameDataViewModelList) {
            List<GameDataTable> gameDataTableList = new ArrayList<>();
            for (GameDataModel gameDataModel : gameDataViewModelList[0]) {
                GameDataTable gameDataTable = new GameDataTable(gameDataModel.getName(), gameDataModel.getViewers(), gameDataModel.getChannels(), gameDataModel.getLogo());
                gameDataTableList.add(gameDataTable);

            }
            appDatabase.gameDataDao().insert(gameDataTableList);
            return null;
        }
    }

}
