package dev.yuri.domain.application.service;

import dev.yuri.domain.application.port.in.GetProductsUseCase;
import dev.yuri.domain.application.port.in.dto.MessageProductDTO;
import dev.yuri.domain.application.port.out.GetProductsPort;
import dev.yuri.domain.application.port.out.dto.MessageDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GetProductMessageService implements GetProductsUseCase {
    @Inject
    GetProductsPort getProductsPort;
    @Override
    public List<MessageProductDTO> getProducts() {
        List<MessageDTO> products = getProductsPort.getProducts();
        List<MessageProductDTO> productDTOS = new ArrayList<>();

        for (var product : products) {
            var messageProductDTO = createMessageProductDTO(product);
            productDTOS.add(messageProductDTO);
        }

        return productDTOS;
    }

    private MessageProductDTO createMessageProductDTO(MessageDTO message) {
        return MessageProductDTO.builder()
                .id(message.getId())
                .name(message.getName())
                .brand(message.getBrand())
                .weight(message.getWeight())
                .build();
    }
}
