package com.pholser.avro;

import com.pholser.domain.Child;
import com.pholser.domain.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pholser.domain.Rating.*;
import static org.assertj.core.api.Assertions.*;

class BinarySchemaTest {
    private BinarySchema<Root> binarySchema;

    @BeforeEach void setUp() {
        binarySchema = new BinarySchema<>(Root.class);
    }

    @Test void emitRootSchema() {
        String schema = binarySchema.emit();

        assertThat(schema)
            .contains("\"namespace\" : \"com.pholser.domain\"");
    }

    @Test void serde() throws Exception {
        Root original =
            Root.builder()
                .x(123)
                .child(
                    Child.builder()
                        .s("asdf")
                        .rating(TV_14)
                        .build())
                .build();

        byte[] raw = binarySchema.write(original);
        Root cooked = binarySchema.read(raw);

        assertThat(cooked).isEqualTo(original);
    }
}
