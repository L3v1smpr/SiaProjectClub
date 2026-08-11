# Proyecto-SIA-Progra-Avanzada
ESPECIFICACIONES PROYECTO NRO 36 - Sistema de Gestión de Actividades Clubes Deportivos

## Requerimientos Funcionales:
0.  **Especificar Horarios.**
1.  **Gestión de socios:** Agregar, modificar, eliminar (Pide permiso de admin).
2.  **Gestión de Actividades:** Registrar actividad, modificar, eliminar (ej. "Clase de musculación", "Zumba" con cupo límite).
3.  **Gestión de Reservas:** Agregar Reserva verificando que el cliente no tenga deuda y que la actividad tenga cupos disponibles (Lanza ExcepcionCupoMaximo). Modificar y eliminar.
4.  **Reportes y filtros:** Listar socios por rut y listar eventos de manera cronológica.

## Estructura de Datos y Clases (Modelo MVC):

### 1. Controlador (`SistemaClub`)
*   **Colección 1 (Mapa):** `HashMap<String, Socio> socios` (La llave es el RUT).
*   **Colección 2 (Lista):** `ArrayList<Actividad> actividades` (Catálogo general).
*   **Métodos principales:** 
    *   `+ registrarSocio(rut: String, nombre: String, edad: int, estado: boolean): void`
    *   `+ registrarActividad(nombre: String, cupoMaximo: int, id: String): void`
    *   `+ inscribirSocioEnActividad(rut: String, indiceActividad: int): void`
    *   `+ getActividades(): ArrayList<Actividad>`
    *   `+ getSocios(): HashMap<String, Socio>`

### 2. Entidades del Dominio (`Socio`, `Actividad`, `Reserva`)
*   **`Socio`:** RUT (String), Nombre (String), Edad (int), tieneDeuda (boolean).
*   **`Actividad` (Clase Padre):** idActividad (String), Nombre (String), CupoMaximo (int), mayorDeEdad (boolean).
    *   **Colección Anidada:** `ArrayList<Reserva> reservas` (Cumplimiento SIA-4).
    *   **Herencia (`ClaseGrupal`):** Añade atributo `Profesor` y sobreescribe el método para mostrar detalles.
    *   **Herencia (`EntrenamientoLibre`):** Añade atributo `requiereAsistencia` y sobreescribe el método para mostrar detalles.
*   **`Reserva`:** idReserva (int), fechaHora (String), rutSocio (String), codigoActividad (String).

## Arquitectura de Paquetes
```text
Proyecto-SIA-Progra-Avanzada/
|
|----main/
|     |--Main.java (Selector de interfaz)
|
|----modelo/
|     |--Socio.java
|     |--Reserva.java
|     |--Actividad.java
|     |--ClaseGrupal.java
|     |--EntrenamientoLibre.java
|
|----excepciones/
|     |--ExcepcionCupoMaximo.java (Detiene ejecución si no hay cupo)
|     |--ExcepcionMorosidad.java  (Detiene ejecución si hay deuda) 
|
|----controlador/
|     |--SistemaClub.java (Lógica de negocio pura, sin impresiones)
|
|----vista/
|     |--MenuConsola.java (Interacción por terminal)
|     |--MenuVentana.java (Interacción por GUI)
|
|----persistencia/
      |--GestorArchivos.java (Guardado batch)