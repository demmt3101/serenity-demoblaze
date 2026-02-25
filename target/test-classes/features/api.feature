@api
Feature: APIs Signup/Login Demoblaze

  Scenario: Crear un usuario nuevo en signup
    When hago signup con un usuario nuevo
    Then la respuesta de signup no debe contener error

  Scenario: Intentar crear un usuario ya existente
    Given existe un usuario registrado
    When hago signup con el mismo usuario
    Then la respuesta de signup debe contener error

  Scenario: Login con credenciales correctas
    Given existe un usuario registrado
    When hago login con credenciales correctas
    Then la respuesta de login debe ser exitosa

  Scenario: Login con credenciales incorrectas
    Given existe un usuario registrado
    When hago login con password incorrecta
    Then la respuesta de login debe contener error