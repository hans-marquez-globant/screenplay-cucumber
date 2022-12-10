package mystore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPageQuestion {

   public static Question<String> loginSectionTitle() {
       return actor -> Text.of(mystore.ui.LoginPage.LOGIN_PAGE_TITLE).answeredBy(actor);
   }

   public static Question<String> wrongLoginWarning() {
        return actor -> Text.of(mystore.ui.LoginPage.WRONG_LOGIN_WARNING).answeredBy(actor);
   }
}
