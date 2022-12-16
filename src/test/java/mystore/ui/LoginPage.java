package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target EMAIL = Target.the("Email input").
            located(By.cssSelector("[data-qa='login-email']"));
    public static Target PASSWORD = Target.the("Password input").
            located(By.cssSelector("[data-qa='login-password']"));
    public static Target SIGN_IN_BUTTON = Target.the("Sign In button").
            located(By.cssSelector("[data-qa='login-button']"));
    public static Target LOGGING_TITLE = Target.the("Login to your account").
            located(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2"));
    public static Target WRONG_EMAIL_PASSWORD = Target.the("Warning message").
            located(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p"));
}
