package qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import qa.ui.CartPage;
import qa.ui.OrderModal;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompletePurchase {
    private CompletePurchase(){}

    public static Performable withValidData() {
        return net.serenitybdd.screenplay.Task.where("{0} completa compra",
                WaitUntil.the(CartPage.PLACE_ORDER, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartPage.PLACE_ORDER),

                WaitUntil.the(OrderModal.NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("Dennis").into(OrderModal.NAME),
                Enter.theValue("Ecuador").into(OrderModal.COUNTRY),
                Enter.theValue("Guayaquil").into(OrderModal.CITY),
                Enter.theValue("4111111111111111").into(OrderModal.CREDIT_CARD),
                Enter.theValue("02").into(OrderModal.MONTH),
                Enter.theValue("2026").into(OrderModal.YEAR),

                Click.on(OrderModal.PURCHASE)
        );
    }
}