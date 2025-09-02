package com.example.microservice.controller;

import com.example.microservice.model.Contact;
import com.example.microservice.service.interfaces.ContactService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

    @Inject
    ContactService contactService;

    @GET
    public List<Contact> getAll() {
        return contactService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return contactService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response create(Contact contact) {
        contactService.save(contact);
        return Response.status(Response.Status.CREATED).entity(contact).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Contact contact) {
        if (contactService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        contact.setId(id);
        contactService.save(contact);
        return Response.ok(contact).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (contactService.findById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        contactService.delete(id);
        return Response.noContent().build();
    }
}