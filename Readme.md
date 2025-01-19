## Challenge Back End Alura - Foro Hub Aplicacion

### Descripción


El objetivo de este challenge fue la creación de una API Rest, y para ello, presentamos a Foro Hub , que es una aplicación desarrollada con Spring donde se simula el funcionamiento del foro del sitio de Alura.

Los estudiantes, profesores y moderadores pueden interactuar. 
Cada uno puede crear y gestionar tópicos de discusión.

A través de este proyecto, se comprende cómo se gestionan los datos detrás de un foro, estableciendo relaciones entre tópicos, respuestas y usuarios.

___

### Funcionalidades


En la API se pueden realizar las siguientes acciones:

Crear un nuevo tópico: Los usuarios pueden agregar nuevos temas de discusión.
Listar todos los tópicos: Consultar todos los tópicos creados en el foro.
Visualizar un tópico específico: Obtener los detalles de un tópico mediante su identificador.
Actualizar un tópico: Modificar la información de un tópico existente.
Eliminar un tópico: Remover un tópico del foro.


___

### Tecnologías Utilizadas

Java 23

Spring Boot

Spring Data JPA

Base de datos MySQL (según configuración)

Maven (gestor de dependencias)



___

### Endpoints de la API

POST /topicos → Permite crear un nuevo tópico

GET /topicos → Se utiliza para listar todos los tópicos

GET /topicos/{id} → Se realizan las consultas a un tópico específico

PUT /topicos/{id} → Se puede actualizar un tópico existente

DELETE /topicos/{id} → Sirve para eliminar un tópico

