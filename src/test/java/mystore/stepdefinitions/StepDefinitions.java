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

    @When("{actor} wait for login form to be loaded")
    public void waitLoadedResults(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.EMAIL, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    @Then("{actor} should see log in status correctly")
    public void shouldSeeLoginStatus(Actor actor) {
        actor.should(
                seeThat("Page", MyAccountPage.loginStatus(),
                        equalTo(Constants.LOGIN_STATUS_TITLE))
        );
    }
    @Then("{actor} should see the login section title")
    public void shouldSeeTheLoginSectionTitle(Actor actor) {
        actor.should(
                seeThat("Login section title is the expected one", mystore.questions.LoginPage.loginsTitle(),
                        equalTo(Constants.LOGIN_TITLE))
        );
    }

    @And("{actor} should see the warning for a wrong login attempt")
    public void heShouldSeeTheWarningForAWrongLoginAttempt(Actor actor) {
        actor.should(
                seeThat("A warning is provided for a wrong login attempt", mystore.questions.LoginPage.loginStatusFailed(),
                        equalTo(Constants.LOGIN_INCORRECT_TEXT))
        );
    }
}
