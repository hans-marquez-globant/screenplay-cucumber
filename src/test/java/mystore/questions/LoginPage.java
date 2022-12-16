package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPage {

    public static Question<String> loginToYourAccountTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TO_YOUR_ACCOUNT_TITLE).answeredBy(actor);
    }
    public static Question<String> loginToYourAccountError() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TO_YOUR_ACCOUNT_ERROR).answeredBy(actor);
    }


}
