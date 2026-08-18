package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionScreen {

    public static final Target BTN_ACEPTAR = Target.the("botón aceptar del diálogo nativo").located(By.id("android:id/button1"));
    public static final Target BTN_CANCELAR = Target.the("botón cancelar del diálogo nativo").located(By.id("android:id/button2"));
    public static final Target LBL_NUMERO_OPERACION = Target.the("número de operación").located(By.id("edu.pe.cibertec.ciberbank:id/lbl_numero_operacion"));
    public static final Target LBL_SALDO_ACTUAL = Target.the("saldo actual").located(By.id("edu.pe.cibertec.ciberbank:id/lbl_saldo"));

}
