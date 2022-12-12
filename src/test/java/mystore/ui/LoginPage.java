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

    public static Target LOGIN_PAGE_TITLE = Target.the("Title in login section")
            .located(By.cssSelector(".login-form h2"));

    public static Target WRONG_LOGIN_WARNING = Target.the("Warning for wrong login attempt")
            .located(By.cssSelector(".login-form p"));
}
