package qa.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import qa.ui.ConfirmationModal;

public class PurchaseConfirmation {
    private PurchaseConfirmation(){}

    public static Question<String> message() {
        return actor -> Text.of(ConfirmationModal.TITLE).answeredBy(actor).trim();
    }
}