package dev.yuri.domain.application.port.in.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductRequest {
    private String name;
    private String brand;
    private Double weight;
}
