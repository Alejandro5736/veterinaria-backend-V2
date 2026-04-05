# 1. Usamos la imagen oficial de MySQL versión 8.0
FROM mysql:8.0

# 2. Configuramos las variables de entorno para que la BD se cree sola
ENV MYSQL_DATABASE=veterinaria
ENV MYSQL_ROOT_PASSWORD=root

# 3. Exponemos el puerto estándar de MySQL
EXPOSE 3306