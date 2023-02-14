package dev.yuri.domain.application.port.in;

import dev.yuri.domain.application.port.in.requests.ProductRequest;

import java.util.UUID;

public interface RegisterProductUseCase {
    UUID registerProduct(ProductRequest productRequest);
}
