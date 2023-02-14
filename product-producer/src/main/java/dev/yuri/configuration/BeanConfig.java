package dev.yuri.configuration;

import dev.yuri.domain.application.port.in.RegisterProductUseCase;
import dev.yuri.domain.application.service.RegisterProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

@ApplicationScoped
public class BeanConfig {
    @Produces
    public RegisterProductUseCase registerProductUseCase() {
        return new RegisterProductService();
    }
}
