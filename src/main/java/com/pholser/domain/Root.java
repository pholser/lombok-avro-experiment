package com.pholser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Root.RootBuilder.class)
public class Root {
    int x;

    @JsonProperty(required = true)
    Child child;

    @JsonPOJOBuilder(withPrefix = "")
    public static class RootBuilder {
    }
}
