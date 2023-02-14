package dev.yuri.configuration;

import dev.yuri.domain.application.port.in.GetProductsUseCase;
import dev.yuri.domain.application.service.GetProductMessageService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

@ApplicationScoped
public class BeanConfig {
    @Produces
    public GetProductsUseCase getProductMessageUseCase() {
        return new GetProductMessageService();
    }
}
