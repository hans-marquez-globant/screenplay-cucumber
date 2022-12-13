package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPage {

    public static Question<String> loginError() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_ERROR).answeredBy(actor);
    }

    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_FORM_TITLE).answeredBy(actor);
    }

}
