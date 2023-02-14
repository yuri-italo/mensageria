package dev.yuri.domain.application.port.out;

import dev.yuri.domain.application.port.out.dto.MessageDTO;

public interface RegisterProductPort {
    void registerProduct(MessageDTO messageDTO);
}
