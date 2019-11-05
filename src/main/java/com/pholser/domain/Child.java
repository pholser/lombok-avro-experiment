package com.pholser.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Builder
@EqualsAndHashCode
@ToString
public class Child {
    @Getter
    @Setter(PACKAGE)
    private String s;

    @Getter
    @Setter(PACKAGE)
    private Rating rating;
}
