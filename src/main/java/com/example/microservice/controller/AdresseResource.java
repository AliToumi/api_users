package com.example.microservice.controller;


import com.example.microservice.model.Adresse;
import com.example.microservice.service.interfaces.AdresseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/adresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdresseResource {

    @Inject
    AdresseService adresseService;

    @GET
    @RolesAllowed({"admin", "user"})
    public List<Adresse> getAll() {
        return adresseService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return adresseService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(Adresse adresse) {
        adresseService.save(adresse);
        return Response.status(Response.Status.CREATED).entity(adresse).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Adresse adresse) {
        if (adresseService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        adresse.setId(id);
        adresseService.save(adresse);
        return Response.ok(adresse).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (adresseService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        adresseService.delete(id);
       return Response.noContent().build();
    }
}

