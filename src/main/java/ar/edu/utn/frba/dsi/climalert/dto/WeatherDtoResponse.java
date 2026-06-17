package ar.edu.utn.frba.dsi.climalert.dto;

import lombok.Data;

@Data
public class WeatherDtoResponse {
  private Current current;
  @Data
  public static class Current {
    private double tempC;
    private int humidity;
    private Condition condition;
    private double windKph;
    private String lastUpdated;
    @Data
    public static class Condition {
      private String text;
    }
  }
}
