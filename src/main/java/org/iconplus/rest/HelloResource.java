package org.iconplus.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("learning") 
public class HelloResource {
    @GET
    @Path("quarkus")
    public Response hello() {
        return Response.ok("success"). build();
    }
    
}
