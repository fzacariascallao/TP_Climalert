package ar.edu.utn.frba.dsi.climalert.repository;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class WeatherDataRepository {
  private final ConcurrentSkipListMap<Long, WeatherData> datos = new ConcurrentSkipListMap<>();
  private final AtomicLong generadorId = new AtomicLong(1);

  public WeatherData save(WeatherData data) {
    if (data.getId() == null) {
      data.setId(generadorId.getAndIncrement());
    }
    datos.put(data.getId(), data);
    return data;
  }

  public Optional<WeatherData> findById(Long id) {
    return Optional.ofNullable(datos.get(id));
  }

  public List<WeatherData> findAll() {
    return new ArrayList<>(datos.values());
  }

  public void deleteById(Long id) {
    datos.remove(id);
  }

  public boolean existById(Long id) {
    return id != null && datos.containsKey(id);
  }

  public WeatherData findLatest() {
    Map.Entry<Long, WeatherData> ultimo = datos.lastEntry();
    return ultimo != null ? ultimo.getValue() : null;
  }
}
