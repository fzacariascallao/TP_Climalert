package ar.edu.utn.frba.dsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrentDto (
  @JsonProperty("temp_c")
  double tempC,
  @JsonProperty("humidity")
  int humidity,
  @JsonProperty("condition")
  ConditionDto condition,
  @JsonProperty("wind_kph")
  double windKph,
  @JsonProperty("last_updated")
  String lastUpdated
) {}