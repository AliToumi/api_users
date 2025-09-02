package com.example.microservice.controller;

import com.example.microservice.model.Facture;
import com.example.microservice.service.interfaces.FactureService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/factures")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FactureResource {

    @Inject
    FactureService factureService;

    @GET
    public List<Facture> getAll() {
        return factureService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return factureService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(Facture facture) {
        factureService.save(facture);
        return Response.status(Response.Status.CREATED).entity(facture).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Facture facture) {
        if (factureService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        facture.setId(id);
        factureService.save(facture);
        return Response.ok(facture).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (factureService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        factureService.delete(id);
        return Response.noContent().build();
    }
}

