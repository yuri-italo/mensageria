package dev.yuri.domain.application.port.out;

import dev.yuri.domain.application.port.out.dto.RegisteredProductDTO;

public interface RegisterProductMessagePort {
    void registerMessage(RegisteredProductDTO productDTO);
}
