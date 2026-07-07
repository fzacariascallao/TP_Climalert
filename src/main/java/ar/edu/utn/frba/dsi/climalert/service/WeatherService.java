package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.adapter.WeatherAdapter;
import ar.edu.utn.frba.dsi.climalert.dto.WeatherDtoResponse;
import ar.edu.utn.frba.dsi.climalert.mapper.WeatherMapper;
import ar.edu.utn.frba.dsi.climalert.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
  private final WeatherAdapter weatherAdapter;
  private final WeatherDataRepository weatherDataRepository;
  private final WeatherMapper mapper;
  @Value("${weather.location}")
  private String location;

  public WeatherService(WeatherAdapter weatherAdapter, WeatherDataRepository repository, WeatherMapper mapper) {
    this.weatherAdapter = weatherAdapter;
    this.weatherDataRepository = repository;
    this.mapper = mapper;
  }

  public void fetchAndStore() {
    WeatherDtoResponse response = weatherAdapter.fetchCurrentWeather(location);
    if (response == null) {
      System.out.println("No se pudo obtener datos de WeatherAPI");
      return;
    }
    weatherDataRepository.save(mapper.toDomain(response));
  }
}
