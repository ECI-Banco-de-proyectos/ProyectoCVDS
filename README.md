# Escuela Colombiana de Ingenieria Julio Garavito
# Proyecto CVDS 2020-1
## Integrantes: 
>- German Andres Ospina Quintero
>- Nicolas Ortega Limas
>- Juan Sebastian Nieto Molina 
>- Brayan Steven Burgos Delgado

## Definicion del proyecto y documentacion del proyecto:
[Definicion del proyecto](https://drive.google.com/file/d/1CUC9XXWHU8wnbFzoWo5ZUM3y5VEtSGhp/view?usp=sharing)
### Descripción General
Esta aplicación tiene como objetivo principal brindar a la comunidad una herramienta fácil y eficiente para la socialización de iniciativas.
Permite a los usuarios proponer e interactuar activamente con las
propuestas; registrando votos, reacciones y comentarios, además de brindar
la opción de poder visualizar los datos en gráficas, de tal manera que sean mucho más amenos al usuario.
### Funcionalidades más Importantes y Manual de Usuario
Cualquier persona que quiera visualizar la información presente en el sistema puede registrase como un usuario básico:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Registro.PNG?raw=true)
Una vez registrado puede logearse ingresando en el botón de abajo presente en la página anterior:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Ingreso.PNG?raw=true)
En nuestro caso ingresaremos como usuario administrador, para poder ver todas las funcionalidades de ofrece la plataforma (german, german):
En está pagina el usuario puede visualizar los datos de todos los usuarios:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Datos%20del%20usuario.PNG?raw=true)
Dando click en el bóton de la última columna es posible modificar el rol de usuario seleccionado:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Modificaci%C3%B3n%20Datos%20del%20Usuario.PNG?raw=true)
En la pestaña Busqueda de Iniciativas se pueden ver todos los datos de las iniciativas registradas:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Busqueda%20de%20iniciativas.PNG?raw=true)
En la parte inferior se puede ver el número de iniciativas por área en forma de un diagrama de barras:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Iniciativas%20por%20%C3%81rea.PNG?raw=true)
En botón con la imagen del lapiz de la penúltima columna se pueden modificar aspectos de las iniciativas, adicionalmente en la opción presente en la última es posible votar por la iniciativa y dejar su comentario sobre esta:
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Modificar%20Iniciativa.PNG?raw=true)
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/Comentario_Voto_Iniciativa.PNG?raw=true)
### Modelo E-R
![enter image description here](https://github.com/ECI-Banco-de-proyectos/ProyectoCVDS/blob/master/imagenes/BD.PNG?raw=true)
## Entrada a Heroku
[Banco de Proyectos](https://proyectocvds2.herokuapp.com/faces/Registro.xhtml)
## Entrada a Circle ci
[Integración continua](https://app.circleci.com/pipelines/github/ECI-Banco-de-proyectos/ProyectoCVDS)
[![CircleCI](https://circleci.com/gh/ECI-Banco-de-proyectos/ProyectoCVDS.svg?style=svg)](https://circleci.com/gh/ECI-Banco-de-proyectos/ProyectoCVDS)

## Informacion de sobre la entrada a la base de datos
>- host : ec2-3-91-112-166.compute-1.amazonaws.com
>- db: d52r0cth9ad4d6
>- user: nxztwufxsnpfki
>- port: 5432
>- pw: 74afdfee69819ba81f37f0f3c0bbcf1d2142f6760609f62db15392a3f2303d17 

## Informacion de la entrada a Taiga:
[Iniciativa y proyectos en Taiga](https://tree.taiga.io/project/germanaoq-plataforma-banco-de-iniciativas-de-proyectos/timeline)

## Comandos MVN para poder compilar el proyecto:
```mvn tomcat7:run``` 

```mvn package```
