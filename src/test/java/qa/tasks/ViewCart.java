package qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import qa.ui.HomePage;

public class ViewCart {
    private ViewCart(){}

    public static Performable open() {
        return Task.where("{0} abre el carrito",
                Click.on(HomePage.CART_LINK)
        );
    }
}