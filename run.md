# ▶️ RUN.md – Instrucciones para Ejecutar el Proyecto

Este documento describe cómo levantar los servidores del **backend (Java + Spring Boot)** y el **frontend (Angular)** para ejecutar correctamente la prueba técnica.

---

## ⚙️ Requisitos Previos

### 🧪 Backend (Java + Spring Boot)

- Java 17 (JDK instalado y configurado en el IDE)
- Maven 3.8+ o Gradle (según el proyecto)
- IDE recomendado: IntelliJ IDEA, Eclipse o VSCode

### 🖥️ Frontend (Angular)

- Node.js (v17 recomendado)
- Angular CLI (`npm install -g @angular/cli`)
- Navegador web moderno (Chrome, Firefox, etc.)

---

## 🧱 Cómo Ejecutar

---

## 🧬 1. Clonar el Proyecto

Clona el repositorio desde GitHub, asegurándote de usar la rama `release`:

🔗 [https://github.com/crojastrianaDev/challenge/tree/release](https://github.com/crojastrianaDev/challenge/tree/release)

---

## ⚙️ 2. Iniciar el Backend (Spring Boot)

### A. Usando IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Selecciona **"Open"** y abre la carpeta `challenge`.
3. IntelliJ detectará automáticamente el proyecto como un proyecto Maven.
4. Asegúrate de que esté configurado **Java 17** como SDK del proyecto.
5. Asegurate de contar con lombok habilitado en el IDE.
6. Espera a que finalice la sincronización de Maven.
7. Ubica la clase principal `Application.java` y haz clic en el botón ▶️ **Run** para iniciar la aplicación.
8. Verifica que se ejecute en el puerto `8080`:  
   👉 [http://localhost:8080](http://localhost:8080)

---

### B. Usando la Terminal (Maven)

1. Abre una terminal dentro de la carpeta `challenge`.
2. Ejecuta los siguientes comandos:

````bash
./mvnw clean install
./mvnw spring-boot:run


## 🖥️ 3. Iniciar el Frontend (Angular)

1. Abre una terminal y navega a la carpeta del frontend:

   ```bash
   cd ../meli
````

2. Instala las dependencias:

   ```bash
   npm install
   ```

3. Inicia el servidor de desarrollo:

   ```bash
   npm run start
   ```

4. La aplicación estará disponible en:  
   👉 [http://localhost:4200](http://localhost:4200)

---

## ✅ 4. Verificación Rápida

- Backend: [http://localhost:8080/api/v1/products](http://localhost:8080/api/v1/products)
- Frontend: [http://localhost:4200](http://localhost:4200)

```

```
