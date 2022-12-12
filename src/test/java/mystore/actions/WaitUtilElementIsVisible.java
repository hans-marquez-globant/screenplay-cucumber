package mystore.actions;

import mystore.ui.LoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitUtilElementIsVisible implements Task {
    private final Target element;
    private static String desiredElement;

    public WaitUtilElementIsVisible(Target element){
        this.element = element;
    }

    public static Performable loginSectionTitle() {
        desiredElement = "Title in login section";
        return Instrumented
                .instanceOf(WaitUtilElementIsVisible.class)
                .withProperties(LoginPage.LOGIN_PAGE_TITLE);
    }

    public static Performable warningForWrongLoginAttempt() {
        desiredElement = "Warning provided while a wrong login attempt";
        return Instrumented
                .instanceOf(WaitUtilElementIsVisible.class)
                .withProperties(LoginPage.WRONG_LOGIN_WARNING);
    }
    
    @Override
    @Step("{0} wait for #desiredElement to be visible")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(this.element, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
