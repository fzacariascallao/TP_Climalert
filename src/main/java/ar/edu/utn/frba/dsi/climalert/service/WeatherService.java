package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.dto.WeatherDtoResponse;
import ar.edu.utn.frba.dsi.climalert.mapper.WeatherMapper;
import ar.edu.utn.frba.dsi.climalert.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
  private final RestTemplate restTemplate;
  private final WeatherDataRepository weatherDataRepository;
  private final WeatherMapper mapper;
  @Value("${weather.api.url}")
  private String apiUrl;
  @Value("${weather.api.key}")
  private String apiKey;
  @Value("${weather.location}")
  private String location;

  public WeatherService(RestTemplate restTemplate, WeatherDataRepository repository, WeatherMapper mapper) {
    this.restTemplate = restTemplate;
    this.weatherDataRepository = repository;
    this.mapper = mapper;
  }

  public void fetchAndStore() {
    String url = apiUrl + "?key=" + apiKey + "&q=" + location;
    WeatherDtoResponse response = restTemplate.getForObject(url, WeatherDtoResponse.class);
    weatherDataRepository.save(mapper.toDomain(response));
  }
}
