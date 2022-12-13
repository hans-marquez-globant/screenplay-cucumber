package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target EMAIL = Target.the("Email input")
            .located(By.cssSelector("[data-qa='login-email']"));
    public static Target PASSWORD = Target.the("Password input")
            .located(By.cssSelector("[data-qa='login-password']"));
    public static Target SIGN_IN_BUTTON = Target.the("Sign In button")
            .located(By.cssSelector("[data-qa='login-button']"));

    public static final Target LOGIN_FORM_TITLE = Target.the("My login form title")
            .located(By.cssSelector(".login-form> h2"));

    public static final Target LOGIN_ERROR = Target.the("My login error message")
            .located(By.cssSelector("[action='/login'] > p"));
}
