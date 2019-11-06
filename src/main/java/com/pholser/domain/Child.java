package com.pholser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Child.Builder.class)
public class Child {
    String s;

    @JsonProperty(required = true)
    Rating rating;

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}
