package com.example.twichstreams.model.twitch_responce;

public class GameDataModel {
    private String name;
    private int viewers;
    private int channels;
    private String logo;

    public GameDataModel(String name, int viewers, int channels, String logo) {
        this.name = name;
        this.viewers = viewers;
        this.channels = channels;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public int getViewers() {
        return viewers;
    }

    public int getChannels() {
        return channels;
    }

    public String getLogo() {
        return logo;
    }

    public static GameDataModel getGameDataModelFromTop(Top top) {
        String name = top.getGame().getName();
        int viewers = top.getViewers();
        int channels = top.getChannels();
        String logo = top.getGame().getLogo().getMedium();
        return new GameDataModel(name, viewers, channels, logo);

    }
}
