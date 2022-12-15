package mystore.questions;

import mystore.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageQuestion {
    public static Question<String> loginFormTitle() {
        return actor -> Text.of(LoginPage. TITLE_FORM ).answeredBy(actor);
    }

    public static Question<String> loginErrorAlert() {
        return actor -> Text.of(LoginPage.LOGIN_ERROR_MESSAGE).answeredBy(actor);
    }
}
