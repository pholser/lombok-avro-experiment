package com.pholser.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RootTest {
    @Test void showMethods() {
        Arrays.stream(Root.class.getDeclaredMethods())
            .forEach(System.out::println);
    }
}
