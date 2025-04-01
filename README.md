# Sistema de Reserva de Habitaciones

Este proyecto es un sistema de gestión de reservas de habitaciones desarrollado en Java, implementando el patrón de diseño MVC (Modelo-Vista-Controlador). El sistema permite gestionar habitaciones, clientes y reservas, asegurando una experiencia fluida y organizada para los usuarios.

## Características Principales

- **Gestión de Habitaciones**: Listar habitaciones, ver detalles y verificar disponibilidad.
- **Gestión de Clientes**: Registrar nuevos clientes, listar clientes existentes y ver detalles de un cliente.
- **Gestión de Reservas**: Crear, listar, cancelar y completar reservas.
- **Validaciones**: Manejo de fechas, disponibilidad de habitaciones y restricciones de reservas activas por cliente.
- **Encapsulación y Modularidad**: Uso de clases bien estructuradas con atributos privados y acceso controlado mediante getters y setters.

## Estructura del Proyecto

El proyecto sigue el patrón MVC, dividiendo la lógica en tres capas principales:

- **Modelo (`src/model`)**: Contiene las clases `Room`, `Client` y `Reservation`, que representan los datos principales del sistema.
- **Vista (`src/view`)**: Contiene las clases `MainView`, `RoomView`, `ClientView` y `ReservationView`, encargadas de interactuar con el usuario.
- **Controlador (`src/controller`)**: Contiene las clases `RoomController`, `ClientController` y `ReservationController`, que gestionan la lógica de negocio.

### Diagrama de Carpetas
src/ 
├── controller/ # Controladores que gestionan la lógica de negocio 
├── model/ # Clases que representan los datos del sistema 
├── view/ # Clases que interactúan con el usuario 
└── App.java # Punto de entrada del programa
