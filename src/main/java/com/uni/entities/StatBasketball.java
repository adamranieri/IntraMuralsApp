package com.uni.entities;

import java.util.Objects;

public class StatBasketball {

    private int statBasketballId;
    private String username;
    private int gameId;
    private String teamName;

    private int points;
    private int rebounds;
    private int assists;
    private int fouls;

    public StatBasketball() {
    }

    public StatBasketball(int statBasketballId, String username, int gameId, String teamName, int points, int rebounds, int assists, int fouls) {
        this.statBasketballId = statBasketballId;
        this.username = username;
        this.gameId = gameId;
        this.teamName = teamName;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.fouls = fouls;
    }

    public int getStatBasketballId() {
        return statBasketballId;
    }

    public void setStatBasketballId(int statBasketballId) {
        this.statBasketballId = statBasketballId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatBasketball that = (StatBasketball) o;
        return statBasketballId == that.statBasketballId && gameId == that.gameId && points == that.points && rebounds == that.rebounds && assists == that.assists && fouls == that.fouls && Objects.equals(username, that.username) && Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statBasketballId, username, gameId, teamName, points, rebounds, assists, fouls);
    }

    @Override
    public String toString() {
        return "StatBasketball{" +
                "statBasketballId=" + statBasketballId +
                ", username='" + username + '\'' +
                ", gameId=" + gameId +
                ", teamName='" + teamName + '\'' +
                ", points=" + points +
                ", rebounds=" + rebounds +
                ", assists=" + assists +
                ", fouls=" + fouls +
                '}';
    }
}
