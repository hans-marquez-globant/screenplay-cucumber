package mystore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.actions.GoToSection;
import mystore.actions.LogsInWith;
import mystore.abilities.NavigateTo;
import mystore.actions.WaitForElementVisible;
import mystore.constants.Constants;
import mystore.questions.LoginPageWithErrorMsg;
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
    public void logsInWith(Actor actor, String username, String password) {
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
                WaitForElementVisible.isElementVisible(LoginPage.EMAIL)
        );
    }

    @Then("{actor} should see log in status correctly")
    public void should_see_login_status(Actor actor) {
        actor.should(
                seeThat("Page", MyAccountPage.loginStatus(),
                        equalTo(Constants.LOGIN_STATUS_TITLE))
        );
    }

    @Then("{actor} should see login error message")
    public void shouldSeeLoginErrorMessage(Actor actor) {
        actor.should(
                seeThat("Login form has error message", LoginPageWithErrorMsg.loginErrMsg(),
                        equalTo(Constants.LOGIN_ERROR_MESSAGE))
        );
    }

    @And("{actor} should see login form title")
    public void shouldSeeLoginFormTitle(Actor actor) {
        actor.should(
                seeThat("Login form title", LoginPageWithErrorMsg.loginFormTitle(),
                        equalTo(Constants.LOGIN_FORM_TITLE))
        );
    }
}
