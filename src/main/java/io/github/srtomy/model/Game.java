package io.github.srtomy.model;

import java.util.List;

public class Game {
    private String theme;
    private String player;
    private List<Keyword> keywords;
    private int actualAttempt = 0;
    private int actualAttemptsMax = 4;
    private int actualHits = 0;
    private int actualHistsMax = 4;

    public boolean hasNewAttemp() {
        return actualAttempt < actualAttemptsMax;
    }

    public void addAttempt() {
        actualAttempt++;
    }

    public boolean hasNewHit() {
        return actualHits < actualHistsMax;
    }

    public void addHit() {
        actualHits++;
    }


    public String getThemeCamelCase() {
        return toCamelCase(theme);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public int getActualAttempt() {
        return actualAttempt;
    }

    public void setActualAttempt(int actualAttempt) {
        this.actualAttempt = actualAttempt;
    }

    public int getActualAttemptsMax() {
        return actualAttemptsMax;
    }

    public void setActualAttemptsMax(int actualAttemptsMax) {
        this.actualAttemptsMax = actualAttemptsMax;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    private String toCamelCase(String s) {
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts) {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    private String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}
