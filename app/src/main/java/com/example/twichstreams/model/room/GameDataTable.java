package com.example.twichstreams.model.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GameDataTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    private String name;
    private int viewers;
    private int channels;
    private String logo;

    public GameDataTable(String name, int viewers, int channels, String logo) {
        this.name = name;
        this.viewers = viewers;
        this.channels = channels;
        this.logo = logo;
    }

    public int getId() {
        return id;
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
}
