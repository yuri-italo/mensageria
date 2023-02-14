package dev.yuri.domain.application.port.in;

import dev.yuri.domain.application.port.in.dto.MessageProductDTO;

import java.util.List;

public interface GetProductsUseCase {
    List<MessageProductDTO> getProducts();
}
