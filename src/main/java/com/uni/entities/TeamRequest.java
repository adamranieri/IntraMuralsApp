package com.uni.entities;

import java.util.Objects;

public class TeamRequest {
    private int teamRequestId;
    private String teamName;
    private String username;
    private String teamRequestStatus;

    public TeamRequest() {
    }

    public TeamRequest(int teamRequestId, String teamName, String username, String teamRequestStatus) {
        this.teamRequestId = teamRequestId;
        this.teamName = teamName;
        this.username = username;
        this.teamRequestStatus = teamRequestStatus;
    }

    public int getTeamRequestId() {
        return teamRequestId;
    }

    public void setTeamRequestId(int teamRequestId) {
        this.teamRequestId = teamRequestId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamRequestStatus() {
        return teamRequestStatus;
    }

    public void setTeamRequestStatus(String teamRequestStatus) {
        this.teamRequestStatus = teamRequestStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamRequest that = (TeamRequest) o;
        return teamRequestId == that.teamRequestId && Objects.equals(teamName, that.teamName) && Objects.equals(username, that.username) && Objects.equals(teamRequestStatus, that.teamRequestStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamRequestId, teamName, username, teamRequestStatus);
    }

    @Override
    public String toString() {
        return "TeamRequest{" +
                "teamRequestId=" + teamRequestId +
                ", teamName='" + teamName + '\'' +
                ", username='" + username + '\'' +
                ", teamRequestStatus='" + teamRequestStatus + '\'' +
                '}';
    }
}
