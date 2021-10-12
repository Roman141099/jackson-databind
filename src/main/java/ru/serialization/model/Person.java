package ru.serialization.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static ru.serialization.views.View.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @JsonView(Private.class)
    private String password;
    @JsonView(Public.class)
    private String username;
    @JsonView(Public.class)
    private int rank;
    @JsonView({PublicWithPartOfPrivate.class, Private.class})
    private String passportSerial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-M-dd HH:mm:ss.SSS")
    private final LocalDateTime time = LocalDateTime.now();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private final LocalDate date = LocalDate.now();
}
