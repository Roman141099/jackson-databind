package ru.serialization.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {

    MALE("Мужчина", 12.3), FEMALE("Женщина", 5);

    private final String descr;
    private final double weight;


    @JsonValue
    public String getDescr() {
        return descr + " с весом " + weight + " кг";
    }
}
