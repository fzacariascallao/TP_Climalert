package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import ar.edu.utn.frba.dsi.climalert.repository.WeatherDataRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertService {
  private final WeatherDataRepository weatherDataRepository;
  private final NotificationService notificationService;

  public AlertService(WeatherDataRepository weatherRepo, NotificationService notificationService) {
    this.weatherDataRepository = weatherRepo;
    this.notificationService = notificationService;
  }

  public void checkAndAlert() {
    WeatherData ultimo = weatherDataRepository.findLatest();
    if (ultimo == null) return;
    if (ultimo.getTemperatura() > 35 && ultimo.getHumedad() > 60) {
      notificationService.sendAlert(ultimo);
    }
  }
}
