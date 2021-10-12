package ru.serialization.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Car implements Serializable {

    private static final long serialVersionUID = 1111L;
    private String carName;
    private int age;
    private String model;

}
