package mystore.actions;

import mystore.ui.LoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitForElementDisplayed implements Task {

    public WaitForElementDisplayed() {
    }

    public static Performable email(){
        return Instrumented
                .instanceOf(WaitForElementDisplayed.class)
                .withProperties();
    }

    @Override
    @Step
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(WaitUntil.the(LoginPage.EMAIL, isVisible()).forNoMoreThan(30).seconds());
    }

}
