package com.example.microservice.controller;

import com.example.microservice.model.Contact;
import com.example.microservice.model.User;
import com.example.microservice.service.interfaces.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<User> getAll() {
        return userService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return userService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(User user) {
        userService.save(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, User user) {
        if (userService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        user.setId(id);
        userService.save(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (userService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        userService.delete(id);
        return Response.noContent().build();
    }
}

