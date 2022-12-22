# Cosmere 🌌

Información sobre el Cosmere, un universo ficticio creado por Brandon Sanderson.

![img.png](doc/cosmere_symbol.png)

## Introducción

Este trabajo es una aplicación que emplea una base de datos en mysql y adapta esa base de datos a través de Hibernate. 
La aplicación muestra opciones de consulta a la base de datos, y permite añadir, modificar y eliminar datos de la misma 
a través de una terminal.

## Manual de usuario 👥
Al ejecutar el programa, se mostrará un menú con las opciones disponibles. Que se describen a continuación:
- Sagas
- Libros
- Planetas 
- Personajes
- Especies
- Magia

Cada una de estas opciones, seran seleccionadas a través de un número y se mostrará un menú con las opciones disponibles
para cada una. Que se describen a continuación:
- Listar
- Añadir
- Modificar
- Eliminar
- 
## Manual de desarrollador 🛠

Existe una base de datos en mysql que contiene la información del Cosmere. Esta base de datos se adapta a través
de Hibernate. Para poder ejecutar el programa, es necesario tener instalado mysql y crear la base de datos. Todas las
clases se encuentran en el archivo entities. En estas se encuentran las anotaciones de Hibernate para poder adaptar
las clases a la base de datos y en el archivo controller se encuentra el menú principal del programa.



