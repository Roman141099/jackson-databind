package ru.serialization.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties({"name"})
public class User {

    private String name;
    private Map<String, String> props;

    @JsonAnyGetter
    public Map<String, String> getProps() {
        return props;
    }
}
