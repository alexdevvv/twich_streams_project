package com.example.twichstreams.model.twitch_responce;

public class Game{
    private String name;
    private int Id;
    private int giantbombId;
    private Box box;
    private Logo logo;
    private String localizedName;
    private String locale;

    public String getName(){
        return name;
    }
    public void setName(String input){
        this.name = input;
    }
    public int getId(){
        return Id;
    }
    public void setId(int input){
        this.Id = input;
    }
    public int getGiantbombId(){
        return giantbombId;
    }
    public void setGiantbombId(int input){
        this.giantbombId = input;
    }
    public Box getBox(){
        return box;
    }
    public void setBox(Box input){
        this.box = input;
    }
    public Logo getLogo(){
        return logo;
    }
    public void setLogo(Logo input){
        this.logo = input;
    }
    public String getLocalizedName(){
        return localizedName;
    }
    public void setLocalizedName(String input){
        this.localizedName = input;
    }
    public String getLocale(){
        return locale;
    }
    public void setLocale(String input){
        this.locale = input;
    }
}
