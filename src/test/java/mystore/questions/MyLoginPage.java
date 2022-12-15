package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MyLoginPage {
    public static Question<String> loginTitle(){
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TITLE).answeredBy(actor);
    }
    public static Question<String> wrongCredentials(){
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_ERROR_ADVICE).answeredBy(actor);
    }
}
