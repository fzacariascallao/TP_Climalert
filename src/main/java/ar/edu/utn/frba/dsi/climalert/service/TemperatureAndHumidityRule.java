package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TemperatureAndHumidityRule implements AlertRule {
  @Value("${alert.temp.threshold}")
  private double tempThreshold;
  @Value("${alert.humidity.threshold}")
  private int humidityThreshold;

  @Override
  public boolean matches(WeatherData data) {
    return data.getTemperatura() > tempThreshold && data.getHumedad() > humidityThreshold;
  }
}
