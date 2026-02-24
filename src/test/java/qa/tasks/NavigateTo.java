package qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable demoblazeHome() {
        return Open.url("https://www.demoblaze.com/");
    }
}