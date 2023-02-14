package dev.yuri.adapter.out.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.yuri.domain.application.port.out.RegisterProductMessagePort;
import dev.yuri.domain.application.port.out.dto.RegisteredProductDTO;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class RegisterProductProducer implements RegisterProductMessagePort {
    @Inject
    ConnectionFactory connectionFactory;

    @Override
    public void registerMessage(RegisteredProductDTO productDTO) {
        try (JMSContext jmsContext = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)){
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonProduct = objectMapper.writeValueAsString(productDTO);

            TextMessage textMessage = jmsContext.createTextMessage(jsonProduct);
            Destination destination = jmsContext.createQueue("registerProduct");

            jmsContext.createProducer().send(destination,textMessage);
            System.out.println("Product was sent successfully");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
