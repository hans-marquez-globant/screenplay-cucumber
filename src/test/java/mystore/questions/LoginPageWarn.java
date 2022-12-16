package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageWarn {
    public static Question<String> loginWarningStatus() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_WARNING_STATUS).answeredBy(actor);
    }
    public static Question<String> loginFormTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TITLE).answeredBy(actor);
    }
}
