package ar.edu.utn.frba.dsi.climalert.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "ubicacion", "pais", "temperatura", "humedad", "condicion", "velocidadViento", "ultimaActualizacion", "fecha"})
@Data
public class WeatherData {
  private Long id;
  private String ubicacion;
  private String pais;
  private double temperatura;
  private int humedad;
  private String condicion;
  private double velocidadViento;
  private String ultimaActualizacion;
  private LocalDateTime fecha;
}
