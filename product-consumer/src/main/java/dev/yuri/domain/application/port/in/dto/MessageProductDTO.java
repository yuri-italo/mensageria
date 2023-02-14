package dev.yuri.domain.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Builder
public class MessageProductDTO implements Serializable {
    private UUID id;
    private String name;
    private String brand;
    private Double weight;
}
