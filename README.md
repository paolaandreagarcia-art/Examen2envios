# Examen 2 - Sistema de Gestión de Envíos (Operador Logístico)

Este proyecto implementa un sistema interactivo de gestión de envíos con interfaz gráfica en Java Swing, aplicando arquitectura **MVC + Service**, el patrón de diseño **Factory Method** y principios **SOLID**.

## Estructura del Proyecto

- `.vscode/`: Configuraciones de ejecución y rutas de fuentes para Visual Studio Code.
- `bin/`: Carpeta destino para los archivos compilados (`.class`).
- `lib/`: Carpeta destinada a librerías externas.
- `src/`: Código fuente de la aplicación.
  - `Logistica.java`: Punto de entrada principal de la aplicación (`main`).
  - `modelo/`: Contiene las clases de dominio (`Envio`, `Terrestre`, `Aereo`, `Maritimo`).
  - `factory/`: Implementación del patrón Factory Method (`FabricaEnvio`, fábricas concretas y `RegistroFabricas`).
  - `servicio/`: Lógica de negocio y gestión de la colección de envíos (`ServicioEnvios`).
  - `controlador/`: Manejo de eventos e interacción entre la vista y los servicios (`EnvioController`).
  - `vista/`: Interfaz gráfica de usuario con Java Swing (`VentanaEnvios`).

## Instrucciones de Ejecución

1. Abrir la carpeta raíz del proyecto en VS Code.
2. Ejecutar la clase `Logistica.java` directamente desde VS Code o compilar desde la terminal:
   ```bash
   javac -d bin -sourcepath src src/Logistica.java
   java -cp bin Logistica
   ```
