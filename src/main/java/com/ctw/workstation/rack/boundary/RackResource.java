package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRequestDTO;
import com.ctw.workstation.rack.service.RackService;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.MDC;

import java.util.UUID;

@Path("/workstation/racks")
public class RackResource {

    @Inject
    RackService rackService;
    // public RackService rackService (final ...)

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRack(RackRequestDTO request) {
        return Response.status(Response.Status.CREATED).entity(rackService.addRack(request)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRacks() {
        return Response.status(Response.Status.OK).entity(rackService.getAllRacks()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showRack(@PathParam("id") UUID rackId) {
        return Response.status(Response.Status.OK).entity(rackService.getRackDTOById(rackId)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeRack(@PathParam("id") UUID teamId) {
        rackService.removeRack(teamId);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRack(@PathParam("id") UUID rackId, RackRequestDTO rack) {
        Rack existingRack = rackService.getRackById(rackId);
        return Response.status(Response.Status.OK).entity(rackService.updateRack(existingRack, rack)).build();
    }

    /*
    private RackService service = RackService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRacks() {
        List<Rack> listOfRacks = service.getAllRacks();
        // RackoutputDTO output = new RackoUTPUTDTO(listOfRacks);
        return Response.status(Response.Status.OK).entity(listOfRacks).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRack(Rack rack) {
        // @RequestBody RackDTO input
        rack = new Rack.RackBuilder(rack.getName(), rack.getSerialNumber(), rack.getStatus(), rack.getTeamId()).build();
        service.addRack(rack);
        return Response.status(Response.Status.CREATED).entity(rack).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showRack(@PathParam("id")String id) {
        Rack rack = service.findRackById(id);
        return Response.status(Response.Status.OK).entity(rack).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRack(@PathParam("id") String idRack, Rack rack) {
        service.updateRack(idRack, rack);
        return Response.status(Response.Status.OK).entity(rack).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeRack(@PathParam("id") String idRack) {
        service.removeRack(idRack);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRacksByStatus(@QueryParam("status") String status) {
        List<Rack> racksByStatus = service.findRacksByStatus(status);
        return Response.status(Response.Status.OK).entity(racksByStatus).build();
    }
    */


}
