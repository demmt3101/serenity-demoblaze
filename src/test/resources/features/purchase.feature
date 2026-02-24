@e2e
Feature: Flujo de compra en Demoblaze

  Scenario: Comprar productos y finalizar compra
    Given el usuario abre Demoblaze
    When agrega los productos configurados
    And visualiza el carrito
    And completa el formulario de compra con datos validos
    Then la compra debe finalizar con el mensaje "Thank you for your purchase!"