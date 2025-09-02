package com.example.microservice.controller;

import com.example.microservice.model.Commande;
import java.util.List;

import com.example.microservice.service.interfaces.CommandeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/commandes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommandeResource {

    @Inject
    CommandeService commandeService;

    @GET
    public List<Commande> getAll() {
        return commandeService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return commandeService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(Commande commande) {
        commandeService.save(commande);
        return Response.status(Response.Status.CREATED).entity(commande).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Commande commande) {
        if (commandeService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        commande.setId(id);
        commandeService.save(commande);
        return Response.ok(commande).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (commandeService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        commandeService.delete(id);
        return Response.noContent().build();
    }
}


