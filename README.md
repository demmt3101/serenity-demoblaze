# ✅ Examen Práctico QA – Serenity BDD + Cucumber (E2E) + SerenityRest (API)

Este proyecto automatiza el **Examen práctico – QA** sobre **Demoblaze**, cubriendo:

- **E2E (UI)**: flujo de compra completo con **Serenity BDD + Cucumber** (WebDriver/Chrome).
- **API (REST)**: pruebas de **signup/login** usando **SerenityRest (RestAssured)** con evidencias
 en consola y reporte Serenity.

---

# 📁 Estructura del Proyecto

serenity-demoblaze/

src/test/resources/features/  
purchase.feature → Flujo E2E de compra (UI)  
api.feature → Casos API signup/login  

src/test/java/qa/  
runners/CucumberTest.java → Runner JUnit4 (suite)  
hooks/CucumberHooks.java → Hooks (setup/teardown)  
stepdefinitions/PurchaseSteps.java → Steps E2E (UI)  
stepdefinitions/ApiSteps.java → Steps API (REST)  
tasks/ui/questions/ → Soporte E2E (Tasks/Questions)  
ui/ → Page Objects (HomePage, CartPage, OrderModal, ConfirmationModal)  

target/ (se crea automáticamente)  
site/serenity/index.html → Reporte Serenity  
Ruta pública del reporte: https://demmt3101.github.io/serenity-demoblaze/target/site/serenity/index.html

---

# ⚙️ Tecnologías Utilizadas

* Java 17
* Maven 3.8+
* Serenity BDD + Cucumber
* SerenityRest (RestAssured)
* Google Chrome (UI)

---

# 📥 Requisitos Previos

## 1️⃣ Java 17

Verificar instalación:

java -version

## 2️⃣ Maven 3.8+

Verificar instalación:

mvn -v

## 3️⃣ Google Chrome

Debe estar instalado para ejecutar la parte E2E (UI).

## 4️⃣ Acceso a internet

Sitio y APIs utilizadas:

https://www.demoblaze.com/  
https://api.demoblaze.com/signup  
https://api.demoblaze.com/login  

---

# 🚀 Instalación

Clonar el repositorio:

git clone <URL_REPOSITORIO>

Entrar al directorio:

cd serenity-demoblaze

---

# 🧪 Casos Cubiertos

## 🔌 API (Demoblaze)

Endpoints:

POST https://api.demoblaze.com/signup  
POST https://api.demoblaze.com/login  

Casos:

* Signup: crear usuario nuevo
* Signup: intentar crear usuario existente
* Login: credenciales correctas
* Login: credenciales incorrectas

📌 Nota: se imprime **request/response en consola** usando logging de SerenityRest/RestAssured.

---

## 🛒 E2E (UI) – Flujo de Compra

Sitio:

https://www.demoblaze.com/

Flujo automatizado:

* Abrir sitio
* Agregar **2 productos** al carrito
* Visualizar carrito
* Place Order
* Completar formulario de compra
* Finalizar compra
* Validar mensaje: **"Thank you for your purchase!"**

---

# ▶️ Ejecución

Todos los comandos se ejecutan desde la raíz del proyecto.

## ✅ Ejecutar toda la suite (API + E2E) y generar reportes

mvn clean verify

---

# 🏷️ Ejecución por Tags

## Solo API

mvn clean verify -Dcucumber.filter.tags="@api"

## Solo E2E

mvn clean verify -Dcucumber.filter.tags="@e2e"

---

# 📊 Evidencia / Reportes

## Reporte Serenity

Ruta:

target/site/serenity/index.html

Abrir en el navegador para ver:

* Features y escenarios
* Pasos ejecutados
* Resultados (pass/fail)
* Evidencias por ejecución

---

# 📦 Ejecución desde cualquier equipo

El proyecto usa rutas relativas, por lo que puede ejecutarse desde cualquier ubicación.

Solo ejecutar:

cd serenity-demoblaze  
mvn clean verify

---

# ⚠️ Troubleshooting

## Problemas comunes (UI / Chrome)

- Si Chrome no abre o falla el driver, validar:
  - Chrome instalado y actualizado
  - Permisos del sistema
  - Reintentar con ejecución limpia: `mvn clean verify`

## Inestabilidad del sitio Demoblaze

Demoblaze puede presentar intermitencias (UI/API).  
Si ocurre un fallo aislado, reintenta la ejecución para confirmar consistencia.

---

# 📚 Archivos Entregables

README.md → instrucciones de ejecución  
conclusiones.txt → hallazgos y conclusiones (si aplica)  
target/site/serenity/index.html → reporte Serenity (evidencia)  

---

# 👨‍💻 Autor

Dennis Montalvo
