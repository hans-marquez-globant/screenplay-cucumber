package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPage {

    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_TITLE).answeredBy(actor);
    }

    public static Question<String> wrongLoginWarningMessage() {
        return actor -> Text.of(mystore.ui.LoginPage.LOGIN_FAILED_TITLE).answeredBy(actor);
    }
}
