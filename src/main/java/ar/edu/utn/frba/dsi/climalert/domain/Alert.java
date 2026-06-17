package ar.edu.utn.frba.dsi.climalert.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Alert {
  Long id;
  double temperatura;
  int humedad;
  LocalDateTime fecha;
  Boolean enviado;
}
