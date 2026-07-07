# Ejercicio Climalert

- Asignatura: Diseño de sistemas de información
- Curso: K3001
- Profesor: Ezequiel Escobar
- Alumno: Facundo Zacarías Callao

---

## Contexto

**Climalert** es un sistema de monitoreo climático y envío automático de alertas. Éste funciona como un servicio autónomo, sin interfaz gráfica, cuya responsabilidad es conectarse periódicamente a un proveedor meteorológico externo, procesar los datos recibidos y notificar por correo electrónico a las entidades correspondientes cuando se detecten condiciones climáticas peligrosas o inusuales. Para esta primera iteración solamente consideraremos como “alerta” a una temperatura mayor a 35° y una humedad superior a 60%.

El Sistema fue desarrollado utilizando Spring Boot y tiene en cuenta los siguientes puntos:

1. <u>Integración con proveedor externo de clima</u>
   - El sistema se integra vía REST con [WeatherAPI](https://www.weatherapi.com/) mediante su endpoint /current.json.
   - La ubicación consultada es fija (en este caso: Buenos Aires).
   - Cada 5 minutos, el sistema obtiene los datos climáticos actuales y los almacena localmente para registro histórico y análisis posterior.

2. <u>Procesamiento de alertas meteorológicas</u>
   - Cada 1 minuto, el sistema analiza la última información disponible del clima.
   - Si se detectan condiciones críticas se genera una alerta.

3. <u>Notificación por correo electrónico</u>
   - Al generarse una alerta, el sistema envía un correo a los siguientes destinatarios:
     - admin@clima.com
     - emergencias@clima.com
     - meteorologia@clima.com
   - El correo incluye el detalle completo del clima.