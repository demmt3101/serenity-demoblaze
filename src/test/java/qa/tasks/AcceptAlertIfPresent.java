package qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.abilities.BrowseTheWeb.as;

public class AcceptAlertIfPresent implements Interaction {

    private final int timeoutMs;

    private AcceptAlertIfPresent(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public static AcceptAlertIfPresent within(int timeoutMs) {
        return new AcceptAlertIfPresent(timeoutMs);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = as(actor).getDriver();
        long end = System.currentTimeMillis() + timeoutMs;

        while (System.currentTimeMillis() < end) {
            try {
                driver.switchTo().alert().accept();
                return;
            } catch (NoAlertPresentException ignored) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        // Si no aparece el alert, no falla (Demoblaze a veces no lo muestra).
    }
}