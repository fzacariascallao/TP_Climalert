package ar.edu.utn.frba.dsi.climalert.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Alert {
  private Long id;
  private double temperatura;
  private int humedad;
  private LocalDateTime fecha;
  private Boolean enviado;
}
