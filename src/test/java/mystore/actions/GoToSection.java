package mystore.actions;

import mystore.ui.MainPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class GoToSection implements Task {
    private Target targetSection;
    private static String chosenSection;

    public GoToSection(Target section) {
        this.targetSection = section;
    }

    public static Performable myAccount() {
        //Intrumented es como si hicieramos una nueva instancia new
        chosenSection = "My Account Section";
        return Instrumented
                .instanceOf(GoToSection.class)
                .withProperties(MainPage.SECTION_LOGIN);
    }

    public static Performable products() {
        chosenSection = "My Products Section";
        return Instrumented
                .instanceOf(GoToSection.class)
                .withProperties(MainPage.SECTION_PRODUCTS);
    }

    @Override
    @Step("{0} decide navigate to section: #chosenSection")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(this.targetSection));
    }
}
