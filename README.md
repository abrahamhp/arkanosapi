# arkanosapi

API Arkanos CRUD de personas como prueba técnica.

Instrucciones:
Para instalar la aplicacion, se debe realizar un git clone de este repositorio https://github.com/abrahamhp/arkanosapi.git , para descargarlo localmente.

Luego de descargar la carpeta, debe Importar esta como proyecto Maven prefereiblemente en el IDE Spring Tool Suite 4.

Para la instalacion localmente siga los siguientes pasos:

1) Construya la API
mvn clean package spring-boot:repackage

2) Ejecute la API ( puerto configurado a 8080 por defecto)
mvn spring-boot:run

3) Ejecute la API del lado del cliente usando la herramienta POSTMAN

Tambien otra forma para ejecutar la API, se debe iniciar el servidor embebido en el IDE Spring Tool Suite 4 y se debe instalar o usar la herramienta POSTMAN.(con descargar version gratuita es suficiente)

Los endpoints de las operaciones de la API Arkanos para su ejecucion se detallan en el documento word "Instrucciones con evidencias para probar API de prueba para Arkanos"  incluido en la carpeta raiz del proyecto.

La Base de Datos usada es H2 la cual no requiere ser instalada fisicamente en el entorno local, ya que tiene una configuracion para funcionar virtualmente en memoria mientras se ejecuta una sesion de la API, y el esquema se crea de manera virtual y automaticamente cada vez que se inicia el servidor embebido del IDE en cuestion, por lo tanto no debe ejecutar el script schema.sql de manera manual, tampoco debe ser borrado ni quitado de la carpeta resources del proyecto.

Para acceder a la tabla del esquema de la Base de Datos H2 de la API creada automaticamente para verificar los datos manipulados por las operaciones de la API, debe ingresar a la consola de H2 http://localhost:8080/h2-console/ , y seguir las instrucciones especificadas en el documento Word sobre como ingresar y consultar los datos de la tabla.

Prerequisites
Java 8 Spring tool Suite Dependencias de : -H2 Database - JPA - Web


#Abraham Hernandez
