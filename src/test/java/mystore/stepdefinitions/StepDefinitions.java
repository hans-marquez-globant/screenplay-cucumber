package mystore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.actions.GoToSection;
import mystore.actions.LogsInWith;
import mystore.abilities.NavigateTo;
import mystore.constants.Constants;
import mystore.questions.MyAccountPage;
import mystore.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.equalTo;


public class StepDefinitions {
    @Given("{actor} open my store site")
    public void openSite(Actor actor) {
        actor.wasAbleTo(NavigateTo.myStoreHomePage());
    }

    @When("{actor} logs in with user {string} and password {string}")
    public void LogsInWith(Actor actor, String username, String password) {
        actor.attemptsTo(
                LogsInWith.credentials(username, password)
        );
    }

    @When("{actor} go to my account section")
    public void goToAccountSection(Actor actor) {
        actor.attemptsTo(
                GoToSection.myAccount()
        );
    }

    @Then("{actor} waits for login form to be loaded")
    public void waitLoadedResults(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.EMAIL, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    @Then("{actor} should see log in status correctly")
    public void shouldSeeLoginStatus(Actor actor) {
        actor.should(
                seeThat("User should see log in status correctly", MyAccountPage.loginStatus(),
                        equalTo(Constants.LOGIN_STATUS_TITLE))
        );
    }


    @And("{actor} can see the title Login to your account")
    public void shouldSeeTheLoginTitle(Actor actor) {
        actor.should(
                seeThat("User should see the title Login to your account", mystore.questions.LoginPage.loginToYourAccountTitle(),
                        equalTo(Constants.LOGIN_TO_YOUR_ACCOUNT_TITLE))
        );
    }


    @Then("{actor} can see the error called Your email or password is incorrect!")
    public void shouldSeeTheLoginError(Actor actor) {
        actor.should(
                seeThat("User should see the title Login to your account", mystore.questions.LoginPage.loginToYourAccountError(),
                        equalTo(Constants.LOGIN_ERROR_TITLE))
        );
    }
}
