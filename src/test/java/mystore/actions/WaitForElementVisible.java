package mystore.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitForElementVisible implements Task {
    private final Target element;
    private static String elementToWaitFor;

    public WaitForElementVisible(Target element) {
        this.element = element;
    }

    public static Performable isElementVisible(Target targetElement) {
        elementToWaitFor = "Target element";
        return Instrumented
                .instanceOf(WaitForElementVisible.class)
                .withProperties(targetElement);
    }

    @Override
    @Step("{0} waits until #elementToWaitFor to be visible")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(this.element, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
