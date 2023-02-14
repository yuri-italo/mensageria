package dev.yuri.adapter.in.web;

import dev.yuri.domain.application.port.in.RegisterProductUseCase;
import dev.yuri.domain.application.port.in.requests.ProductRequest;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("products")
public class RegisterProductController {
    @Inject
    RegisterProductUseCase registerProductUseCase;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerProduct(ProductRequest request) {
        UUID uuid = registerProductUseCase.registerProduct(request);
        return Response.ok("Product registered. id: " + uuid.toString()).build();
    }
}
