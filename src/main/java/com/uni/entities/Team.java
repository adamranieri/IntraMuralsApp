package com.uni.entities;

import java.util.Objects;

public class Team {

    private String name;
    private int captain;
    private String sport;
    private String teamStatus;

    public Team() {
    }

    public Team(String name, int captain, String sport, String teamStatus) {
        this.name = name;
        this.captain = captain;
        this.sport = sport;
        this.teamStatus = teamStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaptain() {
        return captain;
    }

    public void setCaptain(int captain) {
        this.captain = captain;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        this.teamStatus = teamStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (captain != team.captain) return false;
        if (!Objects.equals(name, team.name)) return false;
        if (!Objects.equals(sport, team.sport)) return false;
        return Objects.equals(teamStatus, team.teamStatus);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + captain;
        result = 31 * result + (sport != null ? sport.hashCode() : 0);
        result = 31 * result + (teamStatus != null ? teamStatus.hashCode() : 0);
        return result;
    }
}
