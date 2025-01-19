##                              Foro Hub Aplicacion

### Descripción
El objetivo de este challenge fue desarrollar una API Rest para Foro Hub, una aplicación creada 
con Spring que simula el funcionamiento del foro del sitio de Alura.
En esta plataforma, estudiantes, profesores y moderadores pueden interactuar entre sí. 
Cada usuario tiene la posibilidad de crear y gestionar temas de discusión.
Este proyecto permite comprender cómo se gestionan los datos detrás de un foro, estableciendo 
relaciones entre temas, respuestas y usuarios.


___

### Funcionalidades

La API permite realizar las siguientes acciones:

Crear un nuevo tema: Los usuarios pueden agregar nuevos temas de discusión.
Listar todos los temas: Consultar todos los temas creados en el foro.
Visualizar un tema específico: Obtener los detalles de un tema mediante su identificador.
Actualizar un tema: Modificar la información de un tema existente.
Eliminar un tema: Remover un tema del foro.

___

###            API Endpoints  

    POST /temas → Permite crear un nuevo tema.

    GET /temas → Se utiliza para listar todos los temas.

    GET /temas/{id} → Permite consultar un tema específico.

    PUT /temas/{id} → Permite actualizar un tema existente.

    DELETE /temas/{id} → Sirve para eliminar un tema.

    
### Tecnologías Empleadas

    -   Version: Java 23
    -   Spring Boot
    -   Spring Data JPA
    -   Base de datos MySQL (según configuración)
    -   Maven (gestor de dependencias)



___
