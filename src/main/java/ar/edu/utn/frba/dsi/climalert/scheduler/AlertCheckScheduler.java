package ar.edu.utn.frba.dsi.climalert.scheduler;

import ar.edu.utn.frba.dsi.climalert.service.AlertService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertCheckScheduler {
  private final AlertService alertService;

  public AlertCheckScheduler(AlertService alertService) {
    this.alertService = alertService;
  }

  @Scheduled(fixedRate = 60000)  // 1 minuto
  public void checkAlert() {
    alertService.checkAndAlert();
  }
}
