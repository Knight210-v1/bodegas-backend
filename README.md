# bodegas-backend

Backend del sistema de bodegas y productos, hecho con Java 17 y Spring Boot 3. Usa una base de datos H2 en memoria.

## Requisitos

- Java 17 o superior
- Maven 3.9 o superior

## Cómo ejecutarlo

```bash
mvn spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

Al iniciar, se cargan automáticamente datos de prueba (`DataLoader`): Bodega Norte, Bodega Sur y tres productos asociados.

## Endpoints

| Método | Ruta       | Acción                                              |
|--------|------------|-----------------------------------------------------|
| POST   | `/bodegas` | Registrar bodega                                    |
| GET    | `/bodegas` | Consultar bodegas, incluyendo sus productos asociados |

Ejemplo de `POST /bodegas`:

```json
{
  "nombre": "Bodega Centro",
  "ubicacion": "Carrera 7 #20-30"
}
```

Ejemplo de respuesta de `GET /bodegas`:

```json
[
  {
    "id": 1,
    "nombre": "Bodega Norte",
    "ubicacion": "Calle 170 #45-10",
    "productos": [
      { "id": 1, "nombre": "Computador portátil", "descripcion": "Portátil de 15 pulgadas", "precio": 2500000.0, "cantidad": 15 }
    ]
  }
]
```

## Estructura

```
src/main/java/com/example/bodegas
├── entity        -> Bodega, Producto (relación JPA 1:N)
├── repository    -> BodegaRepository, ProductoRepository
├── dto           -> BodegaDTO, ProductoDTO (evitan referencias circulares)
├── service       -> BodegaService
├── controller    -> BodegaController (REST)
└── config        -> DataLoader (datos de prueba con CommandLineRunner)
```

La consola de H2 está en `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:bodegasdb`, usuario `sa`, sin contraseña).
