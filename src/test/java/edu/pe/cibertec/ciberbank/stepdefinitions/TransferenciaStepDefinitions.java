package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.AceptarConfirmacion;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.IntentarTransferir;
import edu.pe.cibertec.ciberbank.tasks.TransferirMonto;
import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import edu.pe.cibertec.ciberbank.userinterface.DasboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransferenciaStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        try {
            AndroidDriver driver = (AndroidDriver) Serenity.getDriver();
            if (driver != null) {
                // Borra la caché/preferencias del usuario (sinsaldo vs jaime) sin desconectar ADB
                try {
                    driver.executeScript("mobile: clearApp", Map.of("appId", "edu.pe.cibertec.ciberbank"));
                } catch (Exception ignored) {}

                // Inicia la aplicación limpia
                driver.activateApp("edu.pe.cibertec.ciberbank");
            }
        } catch (Exception e) {
            // En el primer test de la suite, Serenity inicializará el driver automáticamente
        }
    }

    @After
    public void tearDown() {
        try {
            AndroidDriver driver = (AndroidDriver) Serenity.getDriver();
            if (driver != null) {
                // Cierra la app limpiamente mediante la API de Appium
                driver.terminateApp("edu.pe.cibertec.ciberbank");
            }
        } catch (Exception ignored) {
        }
    }

    @Dado("que Jaime inició sesión con el usuario {string}")
    public void queJaimeInicioSesion(String usuario) {
        theActorCalled("Jaime").attemptsTo(
                IniciarSesion.con(usuario, "Cibertec123")
        );
    }

    @Cuando("transfiere {string} al beneficiario {string}")
    public void transfiereAlBeneficiario(String monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                TransferirMonto.a(monto, beneficiario)
        );
    }

    @Cuando("intenta transferir {string} al beneficiario {string}")
    public void intentaTransferirAlBeneficiario(String monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                IntentarTransferir.a(monto, beneficiario)
        );
    }

    @Y("acepta el diálogo de confirmación")
    public void aceptaElDialogoDeConfirmacion() {
        theActorInTheSpotlight().attemptsTo(
                AceptarConfirmacion.delDialogo()
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void deberiaVerUnNumeroDeOperacionGenerado() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ConfirmacionScreen.TXT_NUM_OPERACION, isVisible()).forNoMoreThan(12).seconds(),
                Ensure.that(ConfirmacionScreen.TXT_NUM_OPERACION).isDisplayed()
        );
    }

    @Y("el saldo debería quedar en {string}")
    public void elSaldoDeberiaQuedarEn(String saldoEsperado) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DasboardScreen.TXT_SALDO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(DasboardScreen.TXT_SALDO).text().contains(saldoEsperado)
        );
    }

    @Entonces("debería ver el mensaje de error de transferencia {string}")
    public void deberiaVerElMensajeDeError(String mensajeErrorEsperado) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TransferenciaScreen.ERR_MENSAJE, isVisible()).forNoMoreThan(12).seconds(),
                Ensure.that(TransferenciaScreen.ERR_MENSAJE).text().isEqualTo(mensajeErrorEsperado)
        );
    }
}