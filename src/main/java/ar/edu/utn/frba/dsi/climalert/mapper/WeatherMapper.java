package ar.edu.utn.frba.dsi.climalert.mapper;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import ar.edu.utn.frba.dsi.climalert.dto.WeatherDtoResponse;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class WeatherMapper {
  public WeatherData toDomain(WeatherDtoResponse dto) {
    WeatherData data = new WeatherData();
    data.setTemperatura(dto.getCurrent().getTempC());
    data.setHumedad(dto.getCurrent().getHumidity());
    data.setCondicion(dto.getCurrent().getCondition().getText());
    data.setVelocidadViento(dto.getCurrent().getWindKph());
    data.setFecha(LocalDateTime.now());
    return data;
  }
}
