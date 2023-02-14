package dev.yuri.domain.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;
@Builder
@Getter
@ToString
public class RegisteredProductDTO implements Serializable {
    private UUID id;
    private String name;
    private String brand;
    private Double weight;
}
