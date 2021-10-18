package com.example.twichstreams.model.twitch_responce;

public class Top {
    private Game game;
    private int viewers;
    private int channels;

    public Game getGame() {
        return game;
    }

    public void setGame(Game input) {
        this.game = input;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int input) {
        this.viewers = input;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int input) {
        this.channels = input;
    }
}
