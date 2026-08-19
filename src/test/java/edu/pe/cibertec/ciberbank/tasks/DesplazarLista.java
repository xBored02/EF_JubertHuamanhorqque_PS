package edu.pe.cibertec.ciberbank.tasks;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DesplazarLista implements Task {

    public static DesplazarLista hastaElFinal() {
        return instrumented(DesplazarLista.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        AndroidDriver driver = (AndroidDriver) Serenity.getDriver();

        for (int intento = 0; intento < 3; intento++) {
            WebElement lista = driver.findElement(
                    AppiumBy.id("edu.pe.cibertec.ciberbank:id/lst_movimientos")
            );

            Map<String, Object> params = new HashMap<>();
            params.put("elementId", ((RemoteWebElement) lista).getId());
            params.put("direction", "down");
            params.put("percent", 3.0);

            driver.executeScript("mobile: scrollGesture", params);

            String textoActual = driver.findElement(
                    AppiumBy.id("edu.pe.cibertec.ciberbank:id/lbl_contador")
            ).getText();

            if (textoActual.contains("30 de 32")) {
                break; // ya llegamos al estado esperado, no seguimos scrolleando de más
            }
        }
    }
}