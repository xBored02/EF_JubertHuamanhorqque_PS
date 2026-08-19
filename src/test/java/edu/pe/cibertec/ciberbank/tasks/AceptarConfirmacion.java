package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AceptarConfirmacion implements Task {

    public static AceptarConfirmacion delDialogo() {
        return instrumented(AceptarConfirmacion.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfirmacionScreen.BTN_ACEPTAR_DIALOGO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ConfirmacionScreen.BTN_ACEPTAR_DIALOGO)
        );
    }
}