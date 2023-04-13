Feature: Realizar una busqueda en Google

  Como usuario no logueado
  Quiero ingresar a la pagina del buscador de Google
  Para realizar una busqueda
  Y obtener resultados relacionados

  @si
  Scenario Outline: Realizar una busqueda en Google

    Given usuario ingresa en el buscador de Google
    When ingresa una busqueda
          |<busqueda>|
    Then recibe resultados relacionados con la busqueda
          |<busqueda>|

    Examples:
    |busqueda              |
    |que es Jenkins        |
    |por que usar Jenkins  |
