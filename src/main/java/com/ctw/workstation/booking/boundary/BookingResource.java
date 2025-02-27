package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/workstation/bookings")
public class BookingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Hello from Quarkus REST BOOKING!";
    }

    /*
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBooking(Booking booking) {

        booking = new Booking.BookingBuilder(booking.getName(), booking.getTeamId(), booking.getRackId(), booking.getFrom(), booking.getTo()).build();
        // Set a unique id for the rack (this will be generated in the CommonData constructor)
        return Response.status(Response.Status.CREATED)
                .entity(booking)  // Return the rack object in the response body
                .build();
    }

    */

}
