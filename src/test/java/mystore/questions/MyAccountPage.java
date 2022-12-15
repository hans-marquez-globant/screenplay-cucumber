package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MyAccountPage {

   public static Question<String> loginStatus() {
       return actor -> Text.of(mystore.ui.MyAccountPage.LOGIN_STATUS).answeredBy(actor);
    }

    public static Question<String> loginTitle() {
        return actor -> Text.of(mystore.ui.MyAccountPage.LOGIN_TITLE).answeredBy(actor);
    }

    public static Question<String> failedLoginStatus() {
        return actor -> Text.of(mystore.ui.MyAccountPage.FAILED_LOGIN_STATUS).answeredBy(actor);
    }

}
