package dev.yuri.domain.application.port.out;

import dev.yuri.domain.application.port.out.dto.MessageDTO;

import java.util.List;

public interface GetProductsPort {
    List<MessageDTO> getProducts();
}
