package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.DesplazarLista;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MovimientosStepDefinitions {

    @Cuando("abre la pantalla de movimientos")
    public void abreLaPantallaDeMovimientos() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MovimientosScreen.BTN_MOVIMIENTOS, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(MovimientosScreen.BTN_MOVIMIENTOS),

                WaitUntil.the(MovimientosScreen.LST_MOVIMIENTOS, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Entonces("debería ver el contador {string}")
    public void deberiaVerElContador(String contadorEsperado) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MovimientosScreen.LBL_CONTADOR, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(MovimientosScreen.LBL_CONTADOR).text().isEqualTo(contadorEsperado)
        );
    }

    @Cuando("desplaza la lista hasta el final")
    public void desplazaLaListaHastaElFinal() {
        theActorInTheSpotlight().attemptsTo(
                DesplazarLista.hastaElFinal()
        );
    }
}