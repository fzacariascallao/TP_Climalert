package ar.edu.utn.frba.dsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocationDto (
  @JsonProperty("name")
  String name,
  @JsonProperty("country")
  String country
) {}