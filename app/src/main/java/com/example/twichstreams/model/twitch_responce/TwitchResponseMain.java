package com.example.twichstreams.model.twitch_responce;

import java.util.List;

public class TwitchResponseMain {
    private int Total;
    private List<Top> top;

    public int getTotal(){
        return Total;
    }
    public void setTotal(int input){
        this.Total = input;
    }
    public List<Top> getTop(){
        return top;
    }
    public void setTop(List<Top> input){
        this.top = input;
    }

    @Override
    public String toString() {
        return "TwitchResponseMain{" +
                "Total=" + Total +
                ", top=" + top +
                '}';
    }
}

