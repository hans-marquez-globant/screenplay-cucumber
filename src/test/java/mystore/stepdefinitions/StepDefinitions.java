package mystore.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.constants.Constants;
import mystore.actions.LogsInWith;
import mystore.abilities.NavigateTo;
import mystore.questions.MyAccountPage;
import mystore.questions.QuestionLoginPage;
import mystore.ui.MainPage;
import mystore.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.BlurScreenshots;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.screenshots.BlurLevel.HEAVY;
import static org.hamcrest.CoreMatchers.equalTo;


public class StepDefinitions {
    @Given("{actor} open Homepage")
    public void openSite(Actor actor) {
        actor.wasAbleTo(NavigateTo.myStoreHomePage());
    }

    @When("{actor} click on login")
    public void heClickOnLogin(Actor actor) {
        actor.attemptsTo(
                Click.on(MainPage.SECTION_LOGIN)
        );
    }

    @Then("{actor} wait for login form to be loaded")
    public void waitLoadedResults(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.EMAIL, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    @When("{actor} logs in with user {string} and password {string}")
    public void LogsInWith(Actor actor, String email, String password) {
        actor.attemptsTo(
                LogsInWith.credentials(email, password)
        );
    }

    @Then("{actor} should see incorrect email")
    public void shouldSeeIncorrectEmail(Actor actor) {
        actor.should(
                seeThat("Incorrect email or password", QuestionLoginPage.loginStatus(),
                        equalTo(Constants.WRONG_EMAIL_PASSWORD))
        );
    }
}
