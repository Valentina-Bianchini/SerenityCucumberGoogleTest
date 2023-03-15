Feature: Ejecutar API de consulta de personas

  @no
  Scenario Outline: Consulta de datos de usuario

    Given el usuario existe
    When consulta datos de usuario
    |<usuario>|
    Then recibe datos de usuario

  Examples:
    |usuario|
    |2       |
    #|5       |