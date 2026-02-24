package qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    private HomePage(){}

    public static final Target ADD_TO_CART =
            Target.the("botón Add to cart")
                    .located(By.linkText("Add to cart"));

    public static final Target CART_LINK =
            Target.the("link Cart")
                    .located(By.id("cartur"));

    public static final Target HOME =
            Target.the("Home (logo Product Store)")
                    .located(By.id("nava"));

    public static final Target PRODUCT_BY_INDEX =
            Target.the("producto por índice en home")
                    .locatedBy("(//a[contains(@class,'hrefch')])[{0}]");

}