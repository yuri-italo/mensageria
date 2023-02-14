package dev.yuri.adapter.out.persistence;

import dev.yuri.domain.application.port.out.GetProductsPort;
import dev.yuri.domain.application.port.out.RegisterProductPort;
import dev.yuri.domain.application.port.out.dto.MessageDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ProductRepository implements RegisterProductPort, GetProductsPort {
    private List<MessageDTO> messageStorage = new ArrayList<>();

    @Override
    public void registerProduct(MessageDTO messageDTO) {
        messageStorage.add(messageDTO);
    }

    @Override
    public List<MessageDTO> getProducts() {
        return messageStorage;
    }
}
