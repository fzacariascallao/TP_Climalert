package ar.edu.utn.frba.dsi.climalert.adapter;

import ar.edu.utn.frba.dsi.climalert.dto.WeatherDtoResponse;

public interface ClimaAdapter {
  WeatherDtoResponse fetchCurrentWeather(String ubicacion);
}
