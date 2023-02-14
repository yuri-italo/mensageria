package dev.yuri.domain;

import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
@Getter
public class Product {
    private final UUID id;
    private final String name;
    private final String brand;
    private final Double weight;

    public Product(String name, String brand, Double weight) {
        if (fieldsAreCorrect())
            throw new IllegalArgumentException();

        this.id = UUID.randomUUID();
        this.name = name;
        this.brand = brand;
        this.weight = ObjectUtils.defaultIfNull(weight,0.0);
    }

    private boolean fieldsAreCorrect() {
        return StringUtils.isNotBlank(name) && StringUtils.isNotBlank(brand);
    }
}
