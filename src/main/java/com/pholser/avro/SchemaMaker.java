package com.pholser.avro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;
import com.pholser.domain.Root;
import org.apache.avro.Schema;

import java.io.IOException;

public class SchemaMaker {
    public String emit(Class<?> type) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new AvroFactory());
        AvroSchemaGenerator gen = new AvroSchemaGenerator();

        mapper.acceptJsonFormatVisitor(type, gen);

        AvroSchema schemaWrapper = gen.getGeneratedSchema();
        Schema avroSchema = schemaWrapper.getAvroSchema();

        return avroSchema.toString(true);
    }
}
