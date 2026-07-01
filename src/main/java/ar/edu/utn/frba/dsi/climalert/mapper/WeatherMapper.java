package ar.edu.utn.frba.dsi.climalert.mapper;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import ar.edu.utn.frba.dsi.climalert.dto.WeatherDtoResponse;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class WeatherMapper {
  public WeatherData toDomain(WeatherDtoResponse dto) {
    WeatherData data = new WeatherData();
    data.setUbicacion(dto.location().name());
    data.setPais(dto.location().country());
    data.setTemperatura(dto.current().tempC());
    data.setHumedad(dto.current().humidity());
    data.setCondicion(dto.current().condition().text());
    data.setVelocidadViento(dto.current().windKph());
    data.setUltimaActualizacion(dto.current().lastUpdated());
    data.setFecha(LocalDateTime.now());
    return data;
  }
}
