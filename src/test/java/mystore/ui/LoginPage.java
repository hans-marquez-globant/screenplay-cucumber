package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target EMAIL = Target.the("Email input").located(By.cssSelector("[data-qa='login-email']"));
    public static Target PASSWORD = Target.the("Password input").located(By.cssSelector("[data-qa='login-password']"));
    public static Target SIGN_IN_BUTTON = Target.the("Sign In button").located(By.cssSelector("[data-qa='login-button']"));
    public static Target LOGIN_TITLE = Target.the("Title in login form")
            .located(By.cssSelector("div[class='login-form'] h2"));
    public static Target LOGIN_FAILED_TITLE = Target.the("Warning for wrong login attempt")
            .located(By.cssSelector(".login-form p"));
}
