package dev.yuri.domain.application.port.out.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;
@Getter
public class MessageDTO implements Serializable {
    private UUID id;
    private String name;
    private String brand;
    private Double weight;
}
