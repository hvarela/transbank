package com.prueba.transbank.fixture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractFixture<T> {

    public JsonBuilder getJsonBuilder() {
        return new JsonBuilder();
    }

    public abstract T build();

    public final class JsonBuilder {

        private JsonBuilder() {}

        private ObjectMapper objectMapper = new ObjectMapper();

        public String build() {
            try {
                return this.objectMapper.writeValueAsString(AbstractFixture.this.build());
            } catch (JsonProcessingException jsonProcessingException) {
                throw new IllegalStateException(jsonProcessingException);
            }
        }
    }
}