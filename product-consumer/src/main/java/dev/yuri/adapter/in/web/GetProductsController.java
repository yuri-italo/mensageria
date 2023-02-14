package dev.yuri.adapter.in.web;

import dev.yuri.domain.application.port.in.GetProductsUseCase;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("products")
public class GetProductsController {
    @Inject
    GetProductsUseCase getProductsUseCase;
    @GET
    @Path("message")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages() {
        var registeredProducts = getProductsUseCase.getProducts();
        return Response.ok(registeredProducts).build();
    }
}
