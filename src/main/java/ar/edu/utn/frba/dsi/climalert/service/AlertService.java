package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.domain.Alert;
import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import ar.edu.utn.frba.dsi.climalert.mapper.AlertMapper;
import ar.edu.utn.frba.dsi.climalert.repository.WeatherDataRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertService {
  private final WeatherDataRepository weatherDataRepository;
  private final NotificationService notificationService;
  private final AlertMapper alertMapper;

  public AlertService(WeatherDataRepository weatherRepo, NotificationService notificationService, AlertMapper alertMapper) {
    this.weatherDataRepository = weatherRepo;
    this.notificationService = notificationService;
    this.alertMapper = alertMapper;
  }

  public void checkAndAlert() {
    WeatherData ultimo = weatherDataRepository.findLatest();
    if (ultimo == null) return;
    if (ultimo.getTemperatura() > 35 && ultimo.getHumedad() > 60) {
      Alert alerta = alertMapper.toAlert(ultimo);
      notificationService.sendAlert(ultimo);
      alerta.setEnviado(true);
    }
  }
}
