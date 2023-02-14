package dev.yuri.adapter.out.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.yuri.domain.application.port.out.dto.MessageDTO;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.*;

@ApplicationScoped
public class ProductConsumer {
    @Inject
    ConnectionFactory connectionFactory;

    void startListening(@Observes StartupEvent event) {
        try (JMSContext jmsContext = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            Destination destination = jmsContext.createQueue("registerProduct");
            JMSConsumer consumer = jmsContext.createConsumer(destination);

            while (true) {
                Message message = consumer.receive();
                if (message instanceof ObjectMessage) {
                    System.out.println("teste");
                    ObjectMapper objectMapper = new ObjectMapper();
                    MessageDTO messageDTO = objectMapper.readValue(message.getBody(String.class), MessageDTO.class);
                    System.out.println("Received product: " + messageDTO);
                }
            }
        } catch (JMSException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
