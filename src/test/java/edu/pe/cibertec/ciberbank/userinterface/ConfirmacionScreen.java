package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionScreen {

    public static final Target BTN_CONFIRMAR = Target.the("Botón Confirmar")
            .located(By.xpath("//*[@text='Confirmar' or contains(@resource-id, 'btn_confirmar')]"));

    public static final Target BTN_ACEPTAR_DIALOGO = Target.the("Botón Aceptar del diálogo nativo")
            .located(By.xpath("//*[@resource-id='android:id/button1' or @text='Aceptar' or @text='ACEPTAR']"));

    public static final Target BTN_CANCELAR_DIALOGO = Target.the("Botón Cancelar del diálogo nativo")
            .located(By.xpath("//*[@resource-id='android:id/button2' or @text='Cancelar' or @text='CANCELAR']"));

    // Selector flexible por ID
    public static final Target TXT_NUM_OPERACION = Target.the("Número de operación generado")
            .located(By.id("edu.pe.cibertec.ciberbank:id/lbl_numero_operacion"));
}