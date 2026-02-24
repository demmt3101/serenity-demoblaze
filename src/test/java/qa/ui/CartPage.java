package qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    private CartPage(){}

    public static final Target PLACE_ORDER =
            Target.the("botón Place Order")
                    .located(By.xpath("//button[normalize-space()='Place Order']"));
}