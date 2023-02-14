package dev.yuri.domain.application.service;

import dev.yuri.domain.Product;
import dev.yuri.domain.application.port.in.RegisterProductUseCase;
import dev.yuri.domain.application.port.in.requests.ProductRequest;
import dev.yuri.domain.application.port.out.RegisterProductMessagePort;
import dev.yuri.domain.application.port.out.dto.RegisteredProductDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;
@ApplicationScoped
public class RegisterProductService implements RegisterProductUseCase {
    @Inject
    RegisterProductMessagePort messagePort;

    @Override
    public UUID registerProduct(ProductRequest productRequest) {
        var product = new Product(productRequest.getName(), productRequest.getBrand(), productRequest.getWeight());
        messagePort.registerMessage(createProductDTO(product));

        return product.getId();
    }

    private RegisteredProductDTO createProductDTO(Product product) {
        return RegisteredProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .weight(product.getWeight())
                .build();
    }
}
