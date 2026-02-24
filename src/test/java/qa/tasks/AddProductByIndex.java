package qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import qa.ui.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductByIndex {

    private AddProductByIndex(){}

    public static Performable number(int index) {
        return Task.where("{0} agrega el producto #" + index,
                // asegurar home
                WaitUntil.the(HomePage.HOME, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.HOME),

                // abrir producto por índice
                WaitUntil.the(HomePage.PRODUCT_BY_INDEX.of(String.valueOf(index)), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.PRODUCT_BY_INDEX.of(String.valueOf(index))),

                // add to cart + alert
                WaitUntil.the(HomePage.ADD_TO_CART, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ADD_TO_CART),
                AcceptAlertIfPresent.within(3000),

                // volver a home para el siguiente
                Click.on(HomePage.HOME)
        );
    }
}