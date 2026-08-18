package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.RealizarTransferencia;
import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

public class TransferenciaStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown() {
        // Limpieza de estado si fuera requerida por la prueba
    }

    @Dado("que Jaime inició sesión con el usuario {string}")
    public void queJaimeInicióSesiónConElUsuario(String usuario) {
        // Aquí se enlaza con el flujo de inicio de sesión según los datos sembrados del usuario
        OnStage.theActorCalled("Jaime");
    }

    @Cuando("transfiere {double} al beneficiario {string}")
    public void transfiereAlBeneficiario(Double monto, String beneficiario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RealizarTransferencia.alBeneficiario(beneficiario, String.valueOf(monto))
        );
    }

    @Cuando("intenta transferir {int} al beneficiario {string}")
    public void intentaTransferirAlBeneficiario(Integer monto, String beneficiario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RealizarTransferencia.alBeneficiario(beneficiario, String.valueOf(monto))
        );
    }

    @Cuando("intenta transferir {double} al beneficiario {string}")
    public void intentaTransferirDecimalAlBeneficiario(Double monto, String beneficiario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RealizarTransferencia.alBeneficiario(beneficiario, String.valueOf(monto))
        );
    }

    @Cuando("acepta el diálogo de confirmación")
    public void aceptaElDiálogoDeConfirmación() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ConfirmacionScreen.BTN_ACEPTAR)
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void deberíaVerUnNúmeroDeOperaciónGenerado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ConfirmacionScreen.LBL_NUMERO_OPERACION).isDisplayed()
        );
    }

    @Entonces("el saldo debería quedar en {string}")
    public void elSaldoDeberíaQuedarEn(String saldoEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ConfirmacionScreen.LBL_SALDO_ACTUAL).text().isEqualTo(saldoEsperado)
        );
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberíaVerElMensajeDeError(String mensajeError) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TransferenciaScreen.LBL_MENSAJE_ERROR).text().isEqualTo(mensajeError)
        );
    }
}

