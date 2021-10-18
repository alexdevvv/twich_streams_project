package com.example.twichstreams.model.twitch_responce;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitKeeper {
    private static Retrofit retrofit;

    private RetrofitKeeper() {
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
             retrofit = new Retrofit.Builder().baseUrl("https://api.twitch.tv/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
