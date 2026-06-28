package ar.edu.utn.frba.dsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherDtoResponse {
  private Location location;
  private Current current;
  @Data
  public static class Location {
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
  }
  @Data
  public static class Current {
    @JsonProperty("temp_c")
    private double tempC;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("condition")
    private Condition condition;
    @JsonProperty("wind_kph")
    private double windKph;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @Data
    public static class Condition {
      @JsonProperty("text")
      private String text;
    }
  }
}
