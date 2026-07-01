package ar.edu.utn.frba.dsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ConditionDto (
  @JsonProperty("text")
  String text
) {}
