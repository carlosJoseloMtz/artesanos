
# acerca de

Esta es una pequeña aplicación de eCommerce para facilitar un canal de venta para artesanos

# configuración

* Crear un archivo `application-local.properties` dentro del directorio `backend/src/main/resources`, por ejemplo:

```
# db connection
spring.datasource.url=jdbc:mariadb://localhost:3306/artesanos_db
spring.datasource.username=root
spring.datasource.password=pass
```

# instalación

* Este es un proyecto de maven, así que basta con `mvn clean install` para instalarlo
* Crea un esquema de base de datos vacío
* Por ahora, asegúrate de actualizar el archivo `application.properties` dentro del directorio de _resources_ para la conexión a tu ambiente local
* Ejecuta la applicación desde el IDE o desde la línea de comandos

