package qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import qa.questions.PurchaseConfirmation;
import qa.tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseSteps {

    @Given("el usuario abre Demoblaze")
    public void open() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateTo.demoblazeHome()
        );
    }

    @When("agrega los productos configurados")
    public void addConfiguredProducts() {
        var actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                AddProductByIndex.number(1),
                AddProductByIndex.number(2)
        );
    }


    @When("visualiza el carrito")
    public void viewCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(ViewCart.open());
    }

    @When("completa el formulario de compra con datos validos")
    public void completePurchase() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletePurchase.withValidData()
        );
    }


    @Then("la compra debe finalizar con el mensaje {string}")
    public void shouldSeeMessage(String expected) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(PurchaseConfirmation.message(), equalTo(expected))
        );
    }
}