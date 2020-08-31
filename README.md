# Prueba Técnica Transbank

Api para agregar ventas, obtener ventas ,   y login de usuario.  La api tiene token de seguridad Bearer

## Dependencias

* Git
* Git-crypt
* Java 8
* gradle

## Setup Inicial

Las configuraciones en la carpeta  src/main/resources/secrets/ están cifradas utilizando git-crypt. Entonces, antes de ejecutar localmente el proyecto, es necesario configurar su entorno para descifrarlas automaticamente.
La contraseña de git-crypt  por simplicidad esta incorporada en el proyecto  y se llama transbankapi.key


* Instalar el git-crypt en su computadora
* Ejecutar el comando abajo en el root del proyecto

```
git-crypt unlock transbankapi.key
```
## Test Unitarios 

para ejeutar los test unitarios  debe ejecutar el siguiente comado

```
./gradlew unitTest
```


## Test de arquitectura 

para ejeutar los test de arquitectura debe ejecutar el siguiente comado

```
./gradlew architectureTest
```


## Ejecucion del proyecto 


Para ejecutar el proyecto en consola  se debe correr el siguiente comando. la aplicaion se levanta el  localahost:8080

```
./gradlew clean build  bootRun
```



## Usuario Logerado

Para usar el endpoint de logeo   se debe enviar el siguiente payload en el RQ. Que es el unico usario reqistrado.

```
{
	"name": "transbank",
	"password": "transbank2020"
}
```

Este devolvera un token que debe ser enviado en los otros endpoint como **Autorization  Bearer Token**


El token tiene un tiempo de vida que esta configurado en el archivo application.yaml. Si el token expira el usuario no podra utilizar los otros endpoint



## Postman

Se adjunta collecion de postman  con todos los endpoint. Esta se llama restaurant.postman_collection.json  y esta en la raíz del proyecto 
