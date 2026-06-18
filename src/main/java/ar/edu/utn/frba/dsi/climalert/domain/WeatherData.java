package ar.edu.utn.frba.dsi.climalert.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class WeatherData {
  private Long id;
  private double temperatura;
  private int humedad;
  private String condicion;
  private double velocidadViento;
  private LocalDateTime fecha;
}
