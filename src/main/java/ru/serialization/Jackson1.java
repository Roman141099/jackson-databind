package ru.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import lombok.SneakyThrows;
import ru.serialization.model.Car;
import ru.serialization.model.Request;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jackson1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        readSimple(objectMapper);
//        readSimpleFromFile(objectMapper);
//        readSimpleFromNode(objectMapper);
//        readSimpleWithUnknownProps(objectMapper);
        writeDates(objectMapper);
        readDate(objectMapper);
    }

    static void readSimple(ObjectMapper objectMapper) throws JsonProcessingException {
        String content = "{\"carName\":\"BMW\", \"age\":1, \"model\":\"M5\"}";
        Car car = objectMapper.readValue(content, Car.class);
        System.out.println(car);
    }
    static void readSimpleFromFile(ObjectMapper objectMapper) throws IOException {
        File f = new File("src\\main\\resources\\carJson.json");
        Car car = objectMapper.readValue(f, Car.class);
        System.out.println(car);
    }

    static void readSimpleFromNode(ObjectMapper objectMapper) throws IOException {
        String content = "{\"carName\":\"BMW\", \"age\":1, \"model\":\"M5\"}";
        JsonNode node = objectMapper.readTree(content);
        String carName = node.get("carName").asText();
        int age = node.get("age").asInt();
        System.out.println(carName);
        System.out.println(age);
    }

    static void readSimpleWithUnknownProps(ObjectMapper objectMapper) throws IOException {
        String content = "{\"carName\":\"BMW\", \"age\":1, \"model\":\"M5\", \"weight\":123}";
        Car car = objectMapper.readValue(content, Car.class);
        System.out.println(car);
    }

    @SneakyThrows
    static void writeDates(ObjectMapper objectMapper) {
        Request request = new Request("http://google.com", new Date());
        String result = objectMapper.writeValueAsString(request);
        System.out.println(result);
    }

    @SneakyThrows
    static void readDate(ObjectMapper objectMapper) {
        String content = "{" +
                "  \"url\" : \"http://google.com\"," +
                "  \"requestDate\" : \"2021-10-12T09:57:13.874\"" +
                "}";
        Request request = objectMapper.readValue(content, Request.class);
        System.out.println(request);
    }
}
