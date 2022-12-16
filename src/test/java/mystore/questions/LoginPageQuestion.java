package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageQuestion {
    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_FORM_TITTLE).answeredBy(actor);
    }

    public static Question<String> loginWarningMessage() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_WARNING_MESSAGE).answeredBy(actor);
    }
}
