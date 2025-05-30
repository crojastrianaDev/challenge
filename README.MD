# 🛒 Prueba Técnica – Mercado Libre

Este proyecto es una prueba técnica que implementa una solución compuesta por un **backend en Java 17 con Spring Boot 3.5.0** y un **frontend en Angular 17.0.5 y Node 20.10.0**, siguiendo buenas prácticas de desarrollo como Clean Architecture, separación de responsabilidades, y pruebas unitarias.

---

## 📚 Descripción General

El sistema permite:

- Obtener una **lista de productos**
- Consultar un **producto por su ID**

El foco principal del desarrollo fue garantizar una **estructura escalable, mantenible y testeable**, separando adecuadamente la lógica de negocio del resto de componentes.

---

## ⚙️ Backend – Java 17 + Spring Boot

### 🧱 Arquitectura

Se implementó **Clean Architecture** para garantizar un diseño desacoplado, legible y escalable:

- **Dominio:** Contiene entidades las cuales representan el nucleo del negocio.
- **Application:** Orquesta la lógica de negocio sin depender de frameworks.
- **Infraestructura:** En nuestro caso el repository que obtiene data de nuestro Json y la implementacion del use case.
- **Adaptadores:**
  - Controladores REST para recibir las peticiones de los clientes y retornar los datos mediante DTOs y sus Mappers.

### 🧪 Validaciones y Manejo de Errores

- `404 Not Found`: cuando no se encuentra el producto solicitado.
- `400 Bad Request`: cuando hay errores en la solicitud (por ejemplo, campos requeridos faltantes).

### ✅ Pruebas

- Pruebas unitarias desarrolladas para validar la lógica de negocio, servicios y casos de uso.
- Se utilizó asistencia de IA para asegurar una buena cobertura y calidad en los tests.

---

## 🖥️ Frontend – Angular

### 🔧 Estructura

- **Módulos** para una organización clara y modular.
- **Componentes** para vistas (lista y detalle).
- **Servicio Angular** con `HttpClient` y uso de `Observable` para el consumo de APIs.
- **Assets** Almacenamiento de las imagenes de productos.

### 🎨 Diseño

El diseño visual no fue el enfoque principal. Se priorizó la lógica funcional, integrando correctamente con los servicios backend.

### ✅ Pruebas

- Pruebas unitarias básicas sobre componentes y servicios.
- Validación de la interacción entre el servicio y las vistas.

---

## 🚀 Funcionalidades

- **Listar productos**

  - Endpoint: `GET http://localhost:8080/api/v1/products`
  - Vista: Lista el JSON de productos mediante un DTO, evitando retornar todos los datos ya que en la primera pantalla no es necesaria en su totalidad.

    curl --request GET \
    --url http://localhost:8080/api/v1/products \
    --header 'User-Agent: insomnia/11.1.0'

- **Consultar producto por ID**

  - Endpoint: `GET http://localhost:8080/api/v1/products/{id}`
  - Vista: Detalle del producto, en el que retornamos el JSON completo para mostrar con mayor detalle los datos del producto.

  curl --request GET \
  --url http://localhost:8080/api/v1/products/10 \
  --header 'User-Agent: insomnia/11.1.0'

---

## 🧪 Tecnologías Utilizadas

### Backend:

- Java 17
- Spring Boot 3.5.0
- JUnit / Mockito

### Frontend:

- Angular 17
- RxJS
- Jasmine / Karma
