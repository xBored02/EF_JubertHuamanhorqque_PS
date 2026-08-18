# language: es
@transferencia
Característica: Transferencia a beneficiarios
  Antecedentes:
    Dado que Jaime inició sesión con el usuario "jaime"
  Escenario: Transferencia exitosa a un beneficiario
    Cuando transfiere 250.50 al beneficiario "Luis Ramos"
    Y acepta el diálogo de confirmación
    Entonces debería ver un número de operación generado
    Y el saldo debería quedar en "S/ 4,599.50"
  Escenario: El monto excede el límite por operación
    Cuando intenta transferir 3500 al beneficiario "Maria Torres"
    Entonces debería ver el mensaje de error "Excede el límite de S/ 3,000.00 por operación"

  Escenario: Usuario sin saldo intenta realizar una transferencia
    Dado que Jaime inició sesión con el usuario "sinsaldo"
    Cuando intenta transferir 100.00 al beneficiario "Luis Ramos"
    Entonces debería ver el mensaje de error "Saldo insuficiente"
