package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageHas {

    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TITLE).answeredBy(actor);
    }

    public static Question<String> incorrectLoggWarning() {
        return actor -> Text.of(mystore.ui.LoginPage.INCORRECT_LOGG_WARNING).answeredBy(actor);
    }
}
