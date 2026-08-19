package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MovimientosScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private MovimientosScreen() {
    }

    public static final Target BTN_MOVIMIENTOS =
            Target.the("acceso a movimientos").located(By.id(PAQUETE + "btn_movimientos"));

    public static final Target LST_MOVIMIENTOS =
            Target.the("lista de movimientos").located(By.id(PAQUETE + "lst_movimientos"));

    public static final Target LBL_CONTADOR =
            Target.the("contador de movimientos").located(By.id(PAQUETE + "lbl_contador"));
}