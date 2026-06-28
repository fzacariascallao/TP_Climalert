package ar.edu.utn.frba.dsi.climalert.service;

import ar.edu.utn.frba.dsi.climalert.domain.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class NotificationService {
  private final JavaMailSender mailSender;
  @Value("${spring.mail.username}")
  private String from;
  @Value("${weather.alert.emails}")
  private String emailsStr;

  public NotificationService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void sendAlert(WeatherData data) {
    String[] destinatarios = emailsStr.split(",");
    System.out.println("Enviando alerta");
    System.out.println(Arrays.toString(destinatarios));
    String subject = "Alerta Climática - Condiciones Peligrosas";
    String body = """
            Se detectaron condiciones climáticas peligrosas:
            
            Ubicacion: %s
            Pais: %s
            Temperatura: %.1f°C
            Humedad: %d%%
            Condición: %s
            Viento: %.1f km/h
            Fecha: %s
            """.formatted(
        data.getUbicacion(),
        data.getPais(),
        data.getTemperatura(),
        data.getHumedad(),
        data.getCondicion(),
        data.getVelocidadViento(),
        data.getFecha().toString()
    );

    SimpleMailMessage mensaje = new SimpleMailMessage();
    mensaje.setFrom(from);
    mensaje.setTo(destinatarios);
    mensaje.setSubject(subject);
    mensaje.setText(body);
    mailSender.send(mensaje);
  }
}
