package ar.edu.utn.frba.dsi.climalert.dto;

public record WeatherDtoResponse (
  LocationDto location,
  CurrentDto current
) {}
