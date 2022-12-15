package mystore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.actions.GoToSection;
import mystore.actions.LogsInWith;
import mystore.abilities.NavigateTo;
import mystore.actions.WaitElements;
import mystore.constants.Constants;
import mystore.questions.MyAccountPage;
import mystore.questions.MyLoginPage;
import mystore.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.BlurScreenshots;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.screenshots.BlurLevel.HEAVY;
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
                WaitElements.loginInputs()
        );
    }

    @And("{actor} should see login to your account title")
    public void should_see_login_to_your_account_title(Actor actor){
        actor.attemptsTo(WaitElements.loginTitle());
        actor.should(seeThat("Login to your account", MyLoginPage.loginTitle(),
                equalTo(Constants.LOGIN_TITLE)));
    }

    @Then("{actor} should see log in status correctly")
    public void should_see_login_status(Actor actor) {
        actor.should(
                seeThat("Page", MyAccountPage.loginStatus(),
                        equalTo(Constants.LOGIN_STATUS_TITLE))
        );
    }

    @And("{actor} should see the wrong credentials warning")
    public void should_see_the_wrong_credentials_warning(Actor actor){
        actor.attemptsTo(WaitElements.wrongCredentialsWarning());
        actor.should(seeThat("Credentials wrong attempt warning", MyLoginPage.wrongCredentials(),
                equalTo(Constants.LOGIN_ERROR_ADVICE)));
    }
}
