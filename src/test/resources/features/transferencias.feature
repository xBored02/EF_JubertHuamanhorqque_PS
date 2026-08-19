# language: es
Característica: Transferencia a beneficiarios



  @transferencia
  Escenario: Transferencia exitosa a un beneficiario
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando transfiere "250.50" al beneficiario "Luis Ramos - Interbank"
    Y acepta el diálogo de confirmación
    Entonces debería ver un número de operación generado
    Y el saldo debería quedar en "S/ 4,599.50"

  @transferencia
  Escenario: El monto excede el límite por operación
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando intenta transferir "3500" al beneficiario "Maria Torres - BCP"
    Entonces debería ver el mensaje de error de transferencia "Excede el límite de S/ 3,000.00 por operación"

  @transferencia
  Escenario: Usuario sin saldo intenta realizar una transferencia
    Dado que Jaime inició sesión con el usuario "sinsaldo"
    Cuando intenta transferir "100.00" al beneficiario "Pedro Salas - BCP"
    Entonces debería ver el mensaje de error de transferencia "Saldo insuficiente"
