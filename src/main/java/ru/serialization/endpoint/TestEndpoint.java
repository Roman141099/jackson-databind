package ru.serialization.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.serialization.model.Person;

@RestController
public class TestEndpoint {

    @GetMapping
    public Person test(){
        return new Person();
    }

}
