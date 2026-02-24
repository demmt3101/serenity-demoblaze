package qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmationModal {
    private ConfirmationModal(){}

    public static final Target TITLE =
            Target.the("título de confirmación")
                    .located(By.xpath("//div[contains(@class,'sweet-alert')]//h2"));
}