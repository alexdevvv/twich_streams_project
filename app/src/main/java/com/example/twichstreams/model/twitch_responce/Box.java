package com.example.twichstreams.model.twitch_responce;

public class Box {
    private String large;
    private String medium;
    private String small;
    private String template;

    public String getLarge() {
        return large;
    }

    public void setLarge(String input) {
        this.large = input;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String input) {
        this.medium = input;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String input) {
        this.small = input;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String input) {
        this.template = input;
    }
}
