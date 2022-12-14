package mystore.actions;


import mystore.ui.LoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchToLoginElements implements Task {

    private Target element;
    private static String correctElement;

    public SearchToLoginElements(Target element) {
        this.element = element;
    }

    public static Performable LogInInputs() {
        correctElement = "Log in inputs";
        return Instrumented
                .instanceOf(SearchToLoginElements.class)
                .withProperties(LoginPage.EMAIL);
    }

    public static Performable loginTitle() {
        correctElement = "Title of login";
        return Instrumented
                .instanceOf(SearchToLoginElements.class)
                .withProperties(LoginPage.LOGIN_TITLE);
        }

    public static Performable incorrectLoggWarning() {
        correctElement = "Warning for incorrect data in the logg";
        return Instrumented
                .instanceOf(SearchToLoginElements.class)
                .withProperties(LoginPage.INCORRECT_LOGG_WARNING);
        }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.until(Visibility.of(this.element), Matchers.is(true)).forNoMoreThan(35).seconds()
        );

    }
}
