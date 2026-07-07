package ar.edu.utn.frba.dsi.climalert.adapter;

import ar.edu.utn.frba.dsi.climalert.dto.WeatherDtoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiAdapter implements WeatherAdapter {
  private final RestTemplate restTemplate;
  @Value("${weather.api.url}")
  private String apiUrl;
  @Value("${weather.api.key}")
  private String apiKey;
  @Value("${weather.lang}")
  private String lang;

  public WeatherApiAdapter(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public WeatherDtoResponse fetchCurrentWeather(String location) {
    String url = apiUrl + "?key=" + apiKey + "&q=" + location + "&lang=" + lang;
    return restTemplate.getForObject(url, WeatherDtoResponse.class);
  }
}