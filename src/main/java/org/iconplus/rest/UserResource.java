package org.iconplus.rest;

import org.iconplus.dto.UserData;

import java.net.URI;         
// import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List; // Perbaikan impor paket List
import java.util.Map;
import java.util.Objects;

// import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
public class UserResource {
    // private List<UserData> users = new ArrayList<>();

    private Map<String, UserData> users = new HashMap<>();

    @Path("all")
    @GET
    public Response getAllUsers() {
        return Response.ok(users.values()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserData user) {
        // users.add(user);
        users.put(user.getEmail(), user);
        return Response.created(URI.create("/users/" + user.getEmail())).build();
    }

    @Path("{email}")
    @GET
    public Response getUser(String email) {
        UserData user = users.get(email);
        if (Objects.isNull(user)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // String message = "User with email " + email + " telah di temukan.";
        return Response.ok(user).build();
    }

    @Path("{email}")
    @DELETE
    public Response deleteUser(@PathParam("email") String email) {
        UserData user = users.remove(email);
        if (Objects.isNull(user)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        String message = "User with email " + email + " has been deleted.";
        return Response.ok(message ).build();
    }
}
