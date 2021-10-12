package ru.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import ru.serialization.model.*;
import ru.serialization.serializer.CustomInfoDeserializer;
import ru.serialization.serializer.CustomInfoSerializer;
import ru.serialization.views.View;

import java.util.Map;

public class Jackson2 {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        writeAnyGetter(objectMapper);
//        writeJsonGetter(objectMapper);
//        readJsonValue(objectMapper);
//        writeInner(objectMapper);
        writeWithView(objectMapper);
    }

    @SneakyThrows
    static void writeAnyGetter(ObjectMapper objectMapper){
        User user = new User("Name", Map.of("Prop1", "Val1", "Prop2", "Val2"));
        System.out.println(objectMapper.writeValueAsString(user));
    }

    @SneakyThrows
    static void writeJsonGetter(ObjectMapper objectMapper){
        JsonGetterBean jsBean = new JsonGetterBean("Name", 1, Type.FEMALE);
        System.out.println(objectMapper.writeValueAsString(jsBean));
    }

    @SneakyThrows
    static void readJsonValue(ObjectMapper objectMapper){
        String cont = "{" +
                "  \"age\" : 1," +
                "  \"name\" : \"Name\"," +
                "  \"type\" : \"Женщина с весgfgfом 5.0 кг\"" +
                "}";
        JsonGetterBean bean = objectMapper.readValue(cont, JsonGetterBean.class);
        System.out.println();
    }

    @SneakyThrows
    static void writeInner(ObjectMapper objectMapper){

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(CustomInfo.class, new CustomInfoSerializer());
        simpleModule.addDeserializer(CustomInfo.class, new CustomInfoDeserializer());
        objectMapper.registerModule(simpleModule);

        Custom custom = new Custom(new CustomInfo("info 1"));
        System.out.println(objectMapper.writeValueAsString(custom));
        String content = "{" +
                "  \"customInfo\" : {" +
                "    \"str_len\" : 6," +
                "    \"val\" : \"info 1\"" +
                "  }" +
                "}";
        System.out.println(objectMapper.readValue(content, Custom.class));
    }

    @SneakyThrows
    static void writeWithView(ObjectMapper objectMapper){
        Person person = new Person("", "user", 12, "127001");
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY);
        JavaTimeModule timeModule = new JavaTimeModule();
        objectMapper.registerModules(timeModule);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String res = objectMapper.
                writerWithView(View.Private.class).
                writeValueAsString(person);
        System.out.println(res);
    }
}
