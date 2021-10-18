package com.example.twichstreams.controller;

import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.twichstreams.model.twitch_responce.API;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.model.twitch_responce.RetrofitKeeper;
import com.example.twichstreams.model.twitch_responce.Top;
import com.example.twichstreams.model.twitch_responce.TwitchResponseMain;
import com.example.twichstreams.model.twitch_responce.TwitchStreamApi;
import com.example.twichstreams.view.UpdateView;
import com.example.twichstreams.view.recycler_view.TwitchGamesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetDataFromServerController extends GetDataController {
    @Override
   public List<GameDataModel> getData(UpdateView updateView) {
        Retrofit retrofit = RetrofitKeeper.getInstance();
        TwitchStreamApi twitchStreamApi = retrofit.create(TwitchStreamApi.class);

        Call<TwitchResponseMain> callTwitch = twitchStreamApi.getTwitchStream(API.accept, API.client_id);
        callTwitch.enqueue(new Callback<TwitchResponseMain>() {

            @Override
            public void onResponse(Call<TwitchResponseMain> call, Response<TwitchResponseMain> response) {
                List<Top> listTop = new ArrayList<>();
                if (response.isSuccessful()) {
                    listTop = response.body().getTop();
                    updateView.updateView(parseDataFromServer(listTop));
                }
            }

            @Override
            public void onFailure(Call<TwitchResponseMain> call, Throwable t) {
                Log.i("errorOnFailure", t.getMessage());
            }
        });

        return null;
    }

    private List<GameDataModel> parseDataFromServer(List<Top> list) {
        List<GameDataModel> listGameData = new ArrayList<>();
        for (Top top : list) {
            listGameData.add(GameDataModel.getGameDataModelFromTop(top));
        }
        return listGameData;
    }
}
