package com.uni.controllers;

import com.uni.daos.TeamDAO;
import com.uni.models.Team;
import com.uni.services.TeamService;
import com.uni.services.TeamServiceImpl;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.*;

public class TeamController {

    private static TeamService teamService = new TeamServiceImpl(new TeamDAO());

    @OpenApi(
            path = "/teams",
            method = HttpMethod.POST,
            description = "Functionality for registering a team",
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = Team.class)),
            responses = {
                    @OpenApiResponse(status = "204")
            }
    )
    public static void registerTeam(Context context){
        Team team = context.bodyAsClass(Team.class);
        teamService.registerTeam(team);
        context.status(204);
    }

    @OpenApi(
            path = "/teams",
            method = HttpMethod.GET,
            description = "Functionality for retrieving an array of all teams",
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Team.class, isArray = true))
            }
    )
    public static void retrieveAllTeams(Context context){
        context.json(teamService.getAllTeams());
    }
}