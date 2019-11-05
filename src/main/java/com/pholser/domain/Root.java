package com.pholser.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Builder
@EqualsAndHashCode
@ToString
public class Root {
    @Getter
    @Setter(PACKAGE)
    private int x;

    @Getter
    @Setter(PACKAGE)
    private Child child;
}
