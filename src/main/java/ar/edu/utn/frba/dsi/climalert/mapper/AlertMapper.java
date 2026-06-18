package ar.edu.utn.frba.dsi.climalert.mapper;

import ar.edu.utn.frba.dsi.climalert.domain.Alert;
import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class AlertMapper {
  public Alert toAlert(WeatherData data) {
    Alert alert = new Alert();
    alert.setTemperatura(data.getTemperatura());
    alert.setHumedad(data.getHumedad());
    alert.setFecha(LocalDateTime.now());
    alert.setEnviado(false);
    return alert;
  }
}
