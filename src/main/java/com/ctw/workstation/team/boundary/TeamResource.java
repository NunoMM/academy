package com.ctw.workstation.team.boundary;


import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.service.TeamService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.MDC;

import java.util.UUID;

@ApplicationScoped
@Path("/workstation/teams")
// request scoped
// JBossLog
public class TeamResource {

    //private static final Logger logger = Logger.getLogger(String.valueOf(TeamResource.class));

    //@Inject
    //Logger logger;
    // this.logger = logger;

    @Inject
    TeamService teamService;
    // public RackService rackService (final ...)

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTeam(TeamRequestDTO request) {
        return Response.status(Response.Status.CREATED).entity(teamService.addTeam(request)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeams() {
        // Quarkus log
        UUID uuid = UUID.randomUUID();
        MDC.put("traceId", uuid);
        MDC.put("request.path", "/hello/test");
        Log.info("Getting all teams");
        // Logger log
        // logger.info("getTeams");
        return Response.status(Response.Status.OK).entity(teamService.getAllTeams()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showTeam(@PathParam("id") UUID teamId) {
        MDC.put("request.id", teamId);
        MDC.put("request.path", "/hello/test");
        Log.info("Getting teams with id: " + teamId);
        Log.infov("Getting team with id {0}", teamId);
        Log.infof("Getting team with id %s", teamId);
        // LOG CHAMA TOSTRING E HASHCODE, TER CUIDADO COM QUERYS BASE DE DADOS ETC
        return Response.status(Response.Status.OK).entity(teamService.getTeamDTOById(teamId)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeTeam(@PathParam("id") UUID teamId) {
        teamService.removeTeam(teamId);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTeam(@PathParam("id") UUID teamId, TeamRequestDTO Team) {
        Team existingTeam = teamService.getTeamById(teamId);
        return Response.status(Response.Status.OK).entity(teamService.updateTeam(existingTeam, Team)).build();
    }

}