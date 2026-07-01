package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import ar.edu.utn.frba.dsi.climalert.repository.WeatherDataRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertService {
  private final List<AlertRule> reglas;
  private final NotificationService notificationService;
  private final WeatherDataRepository weatherDataRepository;

  public AlertService(List<AlertRule> reglas, NotificationService notificationService,
                      WeatherDataRepository weatherDataRepository) {
    this.reglas = reglas;
    this.notificationService = notificationService;
    this.weatherDataRepository = weatherDataRepository;
  }

  public void checkAndAlert() {
    WeatherData ultimo = weatherDataRepository.findLatest();
    if (ultimo == null) return;

    boolean alerta = reglas.stream().anyMatch(r -> r.matches(ultimo));
    if (alerta) notificationService.sendAlert(ultimo);
  }
}
