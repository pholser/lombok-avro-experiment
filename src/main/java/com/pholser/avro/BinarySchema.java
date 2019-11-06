package com.pholser.avro;

import com.fasterxml.jackson.dataformat.avro.AvroMapper;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;

import java.io.IOException;

class BinarySchema<T> {
    private final Class<T> type;
    private final AvroMapper avro;
    private final AvroSchema schema;

    BinarySchema(Class<T> type) throws IOException {
        this.type = type;
        avro = new AvroMapper();
        schema = avro.schemaFor(type);
    }

    String emit() {
        return schema.getAvroSchema().toString(true);
    }

    byte[] write(T cooked) throws IOException {
        return avro.writer(schema).writeValueAsBytes(cooked);
    }

    T read(byte[] raw) throws IOException {
        return avro.readerFor(type).with(schema).readValue(raw);
    }
}
