package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageQuestions {

    public static Question<String> loginMessage() {
        return actor -> Text.of(mystore.ui.LoginPage.ERROR_MESSAGE).answeredBy(actor);
    }

    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TITLE).answeredBy(actor);
    }
}
