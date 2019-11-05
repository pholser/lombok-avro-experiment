package com.pholser.domain;

import org.junit.jupiter.api.Test;

import static com.pholser.domain.Rating.*;

class RootTest {
    @Test void makingARoot() {
        Root root = Root.builder()
            .x(123)
            .child(Child.builder()
                .s("asdf")
                .rating(TV_14)
                .build())
            .build();
    }
}
