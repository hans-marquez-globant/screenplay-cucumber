package mystore.questions;

import mystore.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageWithErrorMessage {
    public static Question<String> loginFormTitle(){
        return actor -> Text.of(LoginPage.TITLE).answeredBy(actor);
    }
    public static Question<String> loginErrorMessage(){
        return actor -> Text.of(LoginPage.LOGIN_ERROR).answeredBy(actor);
    }
}
