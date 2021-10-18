package com.example.twichstreams.model.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDataDao {

    @Query("SELECT * FROM gamedatatable")
    List<GameDataTable> getAll();

    @Insert
    void insert(List<GameDataTable> gameDataTablesList);

}
