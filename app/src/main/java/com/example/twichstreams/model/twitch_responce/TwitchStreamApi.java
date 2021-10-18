package com.example.twichstreams.model.twitch_responce;

import com.example.twichstreams.model.twitch_responce.TwitchResponseMain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TwitchStreamApi {

    @GET("kraken/games/top")
    Call<TwitchResponseMain> getTwitchStream(@Header("Accept") String accept, @Header("Client-ID") String client_id);

}
