package edu.pe.cibertec.ciberbank.userinterface;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class TransferenciaScreen {

    public static final Target SPN_BENEFICIARIO = Target.the("spinner de beneficiarios").located(By.id("edu.pe.cibertec.ciberbank:id/spn_beneficiario"));
    public static final Target TXT_MONTO = Target.the("campo de monto").located(By.id("edu.pe.cibertec.ciberbank:id/txt_monto"));
    public static final Target BTN_TRANSFERIR = Target.the("botón transferir").located(By.id("edu.pe.cibertec.ciberbank:id/btn_transferir"));
    public static final Target LBL_MENSAJE_ERROR = Target.the("mensaje de error").located(By.id("edu.pe.cibertec.ciberbank:id/lbl_mensaje_error"));

}
