package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPage {
    public static Question<String> loginStatusFailed() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_STATUS_FAILED).answeredBy(actor);
    }
    public static Question<String> loginsTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TITLE).answeredBy(actor);
    }
}
