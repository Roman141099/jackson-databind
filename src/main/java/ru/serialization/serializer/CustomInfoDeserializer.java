package ru.serialization.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.serialization.model.CustomInfo;

import java.io.IOException;

public class CustomInfoDeserializer extends StdDeserializer<CustomInfo> {

    public CustomInfoDeserializer() {
        this(null);
    }

    protected CustomInfoDeserializer(Class<CustomInfo> vc) {
        super(vc);
    }

    @Override
    public CustomInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        return new CustomInfo(root.get("val").asText());
    }
}
