package com.aehp.template.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class NullSerializerProvider extends JsonSerializer<Object> {

    @Override
    public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
        throws IOException, JsonProcessingException {
        arg1.writeString("");
    }
}