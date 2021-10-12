package ru.serialization.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.serialization.model.CustomInfo;

import java.io.IOException;

public class CustomInfoSerializer extends StdSerializer<CustomInfo> {

    public CustomInfoSerializer() {
        this(null);
    }

    protected CustomInfoSerializer(Class<CustomInfo> t) {
        super(t);
    }

    @Override
    public void serialize(CustomInfo customInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("str_len", customInfo.getInfo().length());
        jsonGenerator.writeStringField("val", customInfo.getInfo());
        jsonGenerator.writeEndObject();
    }
}
