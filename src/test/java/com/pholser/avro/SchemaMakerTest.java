package com.pholser.avro;

import com.pholser.domain.Child;
import com.pholser.domain.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pholser.domain.Rating.*;
import static org.assertj.core.api.Assertions.*;

class SchemaMakerTest {
    private SchemaMaker<Root> schemaMaker;

    @BeforeEach void setUp() throws Exception {
        schemaMaker = new SchemaMaker<>(Root.class);
    }

    @Test void emitRootSchema() {
        String schema = schemaMaker.emit();

        assertThat(schema)
            .contains("\"namespace\" : \"com.pholser.domain\"");
    }

    @Test void serde() throws Exception {
        Root original =
            Root.builder()
                .x(123)
                .child(Child.builder()
                    .s("asdf")
                    .rating(TV_14)
                    .build())
                .build();

        byte[] raw = schemaMaker.write(original);
        Root cooked = schemaMaker.read(raw);

        assertThat(cooked).isEqualTo(original);
    }
}
