package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;

public interface AlertRule {
  boolean matches(WeatherData data);
}
