package com.pholser.domain.domain;

import com.pholser.domain.Child;
import com.pholser.domain.Root;
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
