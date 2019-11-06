package com.pholser.avro;

import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions.DateConversion;
import org.apache.avro.data.TimeConversions.TimeMicrosConversion;
import org.apache.avro.data.TimeConversions.TimestampMicrosConversion;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

class BinarySchema<T> {
    private final Schema schema;

    BinarySchema(Class<T> type) {
        ReflectData reflect = ReflectData.get();
        reflect.addLogicalTypeConversion(new DateConversion());
        reflect.addLogicalTypeConversion(new TimeMicrosConversion());
        reflect.addLogicalTypeConversion(new TimestampMicrosConversion());

        schema = reflect.getSchema(type);
    }

    String emit() {
        return schema.toString(true);
    }

    byte[] write(T cooked) throws IOException {
        DatumWriter<T> rootWriter = new ReflectDatumWriter<>(schema);

        try (ByteArrayOutputStream bytesOut = new ByteArrayOutputStream()) {
            BinaryEncoder encoder =
                EncoderFactory.get().binaryEncoder(bytesOut, null);

            rootWriter.write(cooked, encoder);
            encoder.flush();

            return bytesOut.toByteArray();
        }
    }

    T read(byte[] raw) throws IOException {
        DatumReader<T> rootReader = new ReflectDatumReader<>(schema);
        BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(raw, null);

        return rootReader.read(null, decoder);
    }
}
