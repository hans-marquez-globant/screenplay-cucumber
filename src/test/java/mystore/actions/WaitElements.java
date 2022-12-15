package mystore.actions;

import mystore.ui.LoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public abstract class WaitElements implements Task {

    private Target webElement;
    private static String description;


    public WaitElements(Target webElement) {
        this.webElement = webElement;
    }

    public static Performable loginInputs(){
        description = "Login Inputs";
        return Instrumented
                .instanceOf(WaitElements.class)
                .withProperties(LoginPage.EMAIL);
    }

    public static Performable loginTitle(){
        description = "Login section's title";
        return Instrumented
                .instanceOf(WaitElements.class)
                .withProperties(LoginPage.LOGIN_TITLE);
    }

    public static Performable wrongCredentialsWarning(){
        description = "Wrong credentials warning";
        return Instrumented
                .instanceOf(WaitElements.class)
                .withProperties(LoginPage.LOGIN_ERROR_ADVICE);
    }

    @Override
    @Step("{0} wait for #desiredElement to be visible")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(this.webElement, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
