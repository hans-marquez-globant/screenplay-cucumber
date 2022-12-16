package mystore.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.actions.GoToSection;
import mystore.actions.LogsInWith;
import mystore.abilities.NavigateTo;
import mystore.constants.Constants;
import mystore.questions.LoginPageWarn;
import mystore.questions.MyAccountPage;
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

    @Then("{actor} should be see log in warning message")
    public void shouldSeeLoginWarning(Actor actor) {
        actor.should(
                seeThat("Page", LoginPageWarn.loginWarningStatus(),
                        equalTo(Constants.LOGIN_WARNING_STATUS))
        );
    }

    @Then("{actor} should be see log in title")
    public void shouldBeSeeLoginTitle(Actor actor) {
        actor.should(
        seeThat("Page", LoginPageWarn.loginFormTitle(),
        equalTo(Constants.LOGIN_TITLE))
        );
    }
}
