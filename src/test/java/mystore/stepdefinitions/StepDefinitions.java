package mystore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.abilities.NavigateTo;
import mystore.actions.GoToSection;
import mystore.actions.LogsInWith;
import mystore.actions.WaitForElementDisplayed;
import mystore.constants.Constants;
import mystore.questions.LoginPageQuestion;
import mystore.questions.MyAccountPage;
import mystore.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
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

    @And("{actor} wait for login form to be loaded")
    public void waitLoadedResults(Actor actor) {
        actor.attemptsTo(
                WaitForElementDisplayed.isElementDisplayed(LoginPage.EMAIL)
        );
    }

    @Then("{actor} should see log in status correctly")
    public void shouldSeeLoginStatus(Actor actor) {
        actor.should(
                seeThat("Page", MyAccountPage.loginStatus(),
                        equalTo(Constants.LOGIN_STATUS_TITLE))
        );
    }

    @Then("{actor} should see the login form title")
    public void heShouldSeeTheLoginFormTitle(Actor actor) {
        actor.should(
                seeThat("Login form tittle", LoginPageQuestion.loginTitle(),
                        equalTo(Constants.LOGIN_FORM_TITLE))
        );
    }

    @Then("{actor} should see a warning message for wrong credentials")
    public void heShouldSeeAWarningMessageForWrongCredentials(Actor actor) {
        actor.should(
                seeThat("Warning login message for wrong credentials", LoginPageQuestion.loginWarningMessage(),
                        equalTo(Constants.LOGIN_WARNING_MESSAGE))
        );
    }
}
