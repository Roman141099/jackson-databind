package ru.serialization.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.serialization.serializer.CustomInfoSerializer;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Custom {

    private CustomInfo customInfo;

}
