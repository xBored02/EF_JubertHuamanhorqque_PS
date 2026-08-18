package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class RealizarTransferencia implements Task {

    private final String beneficiario;
    private final String monto;

    public RealizarTransferencia(String beneficiario, String monto) {
        this.beneficiario = beneficiario;
        this.monto = monto;
    }

    public static RealizarTransferencia alBeneficiario(String beneficiario, String monto) {
        return Tasks.instrumented(RealizarTransferencia.class, beneficiario, monto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(beneficiario).from(TransferenciaScreen.SPN_BENEFICIARIO),
                Enter.theValue(monto).into(TransferenciaScreen.TXT_MONTO),
                Click.on(TransferenciaScreen.BTN_TRANSFERIR)
        );
    }

}
