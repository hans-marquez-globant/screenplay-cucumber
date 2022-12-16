package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPage {

    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGGING_TITLE).answeredBy(actor);
    }

    public static Question<String> warningMessage() {
        return actor -> Text.of(mystore.ui.LoginPage.WRONG_EMAIL_PASSWORD).answeredBy(actor);
    }

}
