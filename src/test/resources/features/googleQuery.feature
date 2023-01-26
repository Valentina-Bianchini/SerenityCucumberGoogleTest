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
    |busqueda                             |
    |quien escribio la cancion mayonesa   |
    #|tips para limpiar la casa            |
    #|que le paso a utilisima              |
    #|quien se ha tomado todo el vino      |
