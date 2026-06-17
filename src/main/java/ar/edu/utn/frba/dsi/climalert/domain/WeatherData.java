package ar.edu.utn.frba.dsi.climalert.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class WeatherData {
  Long id;
  double temperatura;
  int humedad;
  String condicion;
  double velocidadViento;
  LocalDateTime fecha;
}
