package mystore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.actions.GoToSection;
import mystore.actions.LogsInWith;
import mystore.abilities.NavigateTo;
import mystore.actions.WaitUtilElementIsVisible;
import mystore.constants.Constants;
import mystore.questions.MyAccountPageQuestion;
import mystore.questions.LoginPageQuestion;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class StepDefinitions {
    @Given("{actor} open my store site")
    public void openSite(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.myStoreHomePage()
        );
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
                WaitUtilElementIsVisible.loginForm()
        );
    }

    @Then("{actor} should see log in status correctly")
    public void should_see_login_status(Actor actor) {
        actor.should(
                seeThat("Page", MyAccountPageQuestion.loginStatus(),
                        equalTo(Constants.LOGIN_STATUS_TITLE))
        );
    }

    @Then("{actor} should see the login section title")
    public void heShouldSeeTheLoginSectionTitle(Actor actor) {
        actor.attemptsTo(
                WaitUtilElementIsVisible.loginSectionTitle()
        );
        actor.should(
                seeThat("Login section title is the expected one", LoginPageQuestion.loginSectionTitle(),
                        equalTo(Constants.LOGIN_PAGE_TITLE))
        );
    }

    @And("{actor} should see the warning for a wrong login attempt")
    public void heShouldSeeTheWarningForAWrongLoginAttempt(Actor actor) {
        actor.attemptsTo(
                WaitUtilElementIsVisible.warningForWrongLoginAttempt()
        );
        actor.should(
                seeThat("A warning is provided for a wrong login attempt", LoginPageQuestion.wrongLoginWarning(),
                        equalTo(Constants.WRONG_LOGIN_WARNING))
        );
    }
}
