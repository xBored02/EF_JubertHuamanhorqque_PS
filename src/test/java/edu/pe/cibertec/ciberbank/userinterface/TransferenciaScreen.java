package edu.pe.cibertec.ciberbank.userinterface;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class TransferenciaScreen {

    public static final Target SPN_BENEFICIARIO = Target.the("Spinner de beneficiarios")
            .located(By.id("edu.pe.cibertec.ciberbank:id/spn_beneficiario"));

    public static final Target OPT_BENEFICIARIO = Target.the("Opción del beneficiario {0}")
            .locatedBy("//*[contains(@text, '{0}')]");

    public static final Target INP_MONTO = Target.the("Campo para el monto a transferir")
            .located(By.id("edu.pe.cibertec.ciberbank:id/inp_monto"));

    public static final Target BTN_CONTINUAR = Target.the("Boton continuar transferencia")
            .located(By.xpath("//*[@text='Continuar' or contains(@resource-id, 'btn_procesar')]"));

    // Selector flexible por ID o texto
    public static final Target ERR_MENSAJE = Target.the("Mensaje de error de transferencia")
            .located(By.id("edu.pe.cibertec.ciberbank:id/err_transferencia"));
}