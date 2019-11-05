package com.pholser.avro;

import com.pholser.domain.Root;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchemaMakerTest {
    @Test void emitRootSchema() throws Exception {
        String schema = new SchemaMaker().emit(Root.class);

        assertEquals("asdasda", schema);
    }
}
