package ar.edu.utn.frba.dsi.climalert.controller;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import ar.edu.utn.frba.dsi.climalert.repository.WeatherDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClimaController {
  private final WeatherDataRepository weatherRepo;
  public ClimaController(WeatherDataRepository weatherRepo) {
    this.weatherRepo = weatherRepo;
  }
  @GetMapping("/clima/ultimo")
  public WeatherData ultimo() {
    return weatherRepo.findLatest();
  }
  @GetMapping("/clima/todos")
  public List<WeatherData> todos() {
    return weatherRepo.findAll();
  }
}
