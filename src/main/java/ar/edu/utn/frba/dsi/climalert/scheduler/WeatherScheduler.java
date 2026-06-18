package ar.edu.utn.frba.dsi.climalert.scheduler;

import ar.edu.utn.frba.dsi.climalert.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {
  private final WeatherService weatherService;

  public WeatherScheduler(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @Scheduled(fixedRate = 300000)  // 5 minutos
  public void fetchWeather() {
    weatherService.fetchAndStore();
  }
}
