package mystore.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitForElementDisplayed implements Task {

    private final Target element;

    public WaitForElementDisplayed(Target element) {
        this.element = element;
    }

    public static Performable isElementDisplayed(Target targetElement){
        return Instrumented
                .instanceOf(WaitForElementDisplayed.class)
                .withProperties(targetElement);
    }

    @Override
    @Step
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(WaitUntil.the(this.element, isVisible()).forNoMoreThan(30).seconds());
    }

}
