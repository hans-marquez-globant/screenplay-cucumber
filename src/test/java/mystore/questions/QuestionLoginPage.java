package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class QuestionLoginPage {
    public static Question<String> loginStatus() {
        return actor -> Text.of(mystore.ui.LoginPage.INCORRECT_EMAIL).answeredBy(actor);
    }
}
