package com.example.twichstreams.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.twichstreams.R;
import com.example.twichstreams.controller.GetDataController;
import com.example.twichstreams.controller.GetDataFromDBController;
import com.example.twichstreams.controller.GetDataFromServerController;
import com.example.twichstreams.model.twitch_responce.GameDataModel;
import com.example.twichstreams.view.recycler_view.TwitchGamesAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UpdateView {

    private RecyclerView recyclerView;
    private GetDataFromServerController getDataFromServerController = new GetDataFromServerController();
    private GetDataController getDataFromDBController = new GetDataFromDBController();
    private TwitchGamesAdapter twitchGamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        twitchGamesAdapter = new TwitchGamesAdapter();
        getDataFromServerController.getData(this, getApplicationContext());
        if(!getDataFromServerController.getInternetConnect()) {
            getDataFromDBController = new GetDataFromDBController();
            getDataFromDBController.getData(this, getApplicationContext());
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(twitchGamesAdapter);
    }

    @Override
    public void updateViewMethod(List<GameDataModel> gameDataModelsList) {
        twitchGamesAdapter.setData(gameDataModelsList);
    }
}