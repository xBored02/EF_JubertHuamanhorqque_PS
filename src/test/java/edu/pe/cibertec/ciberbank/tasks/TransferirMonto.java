package edu.pe.cibertec.ciberbank.tasks;


import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import edu.pe.cibertec.ciberbank.userinterface.DasboardScreen;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransferirMonto implements Task {

    private final String monto;
    private final String beneficiario;

    public TransferirMonto(String monto, String beneficiario) {
        this.monto = monto;
        this.beneficiario = beneficiario;
    }

    public static TransferirMonto a(String monto, String beneficiario) {
        return instrumented(TransferirMonto.class, monto, beneficiario);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DasboardScreen.BTN_TRANSFERIR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DasboardScreen.BTN_TRANSFERIR),

                WaitUntil.the(TransferenciaScreen.SPN_BENEFICIARIO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.SPN_BENEFICIARIO),

                WaitUntil.the(TransferenciaScreen.OPT_BENEFICIARIO.of(beneficiario), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.OPT_BENEFICIARIO.of(beneficiario)),

                Enter.theValue(monto).into(TransferenciaScreen.INP_MONTO),

                WaitUntil.the(TransferenciaScreen.BTN_CONTINUAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.BTN_CONTINUAR),

                WaitUntil.the(ConfirmacionScreen.BTN_CONFIRMAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ConfirmacionScreen.BTN_CONFIRMAR)
        );
    }
}