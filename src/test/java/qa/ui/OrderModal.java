package qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderModal {
    private OrderModal(){}

    public static final Target NAME = Target.the("Name").located(By.id("name"));
    public static final Target COUNTRY = Target.the("Country").located(By.id("country"));
    public static final Target CITY = Target.the("City").located(By.id("city"));
    public static final Target CREDIT_CARD = Target.the("Credit card").located(By.id("card"));
    public static final Target MONTH = Target.the("Month").located(By.id("month"));
    public static final Target YEAR = Target.the("Year").located(By.id("year"));

    public static final Target PURCHASE =
            Target.the("botón Purchase")
                    .located(By.xpath("//button[normalize-space()='Purchase']"));
}