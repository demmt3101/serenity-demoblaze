EJERCICIO QA - Serenity BDD + Cucumber (E2E) + SerenityRest (API)
Proyecto: serenity-demoblaze

REQUISITOS
- Java 17
- Maven 3.8+
- Google Chrome instalado
- Conexión a internet (Demoblaze)

ESTRUCTURA (resumen)
- src/test/resources/features
  - purchase.feature  (E2E compra)
  - api.feature       (API signup/login)
- src/test/java/qa
  - runners/CucumberTest.java
  - hooks/CucumberHooks.java
  - stepdefinitions/PurchaseSteps.java
  - stepdefinitions/ApiSteps.java
  - tasks/ui/questions (soporte E2E)
  - ui (HomePage, CartPage, OrderModal, ConfirmationModal)

EJECUCIÓN
1) Ejecutar toda la suite (API + E2E) y generar reportes:
   mvn clean verify

2) Ejecución desde IntelliJ:
   Ejecutar la clase qa.runners.CucumberTest (JUnit4)

EJECUCIÓN POR TAGS
- Solo API:
  mvn clean verify -Dcucumber.filter.tags="@api"

- Solo E2E:
  mvn clean verify -Dcucumber.filter.tags="@e2e"

EVIDENCIA / REPORTES
- Reporte Serenity:
  target/site/serenity/index.html

CASOS CUBIERTOS
API (Demoblaze)
- Signup: crear usuario nuevo
- Signup: intentar crear usuario existente
- Login: credenciales correctas
- Login: credenciales incorrectas
Nota: se registran request/response en consola con logging de SerenityRest/RestAssured.

E2E (Demoblaze)
- Abrir sitio
- Agregar 2 productos al carrito
- Visualizar carrito
- Place Order
- Completar formulario
- Finalizar compra
- Validar mensaje: "Thank you for your purchase!"