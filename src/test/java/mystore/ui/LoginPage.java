package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target EMAIL = Target.the("Email input").located(By.cssSelector("[data-qa='login-email']"));
    public static Target PASSWORD = Target.the("Password input").located(By.cssSelector("[data-qa='login-password']"));
    public static Target SIGN_IN_BUTTON = Target.the("Sign In button").located(By.cssSelector("[data-qa='login-button']"));
    public static Target LOGIN_TO_YOUR_ACCOUNT_TITLE = Target.the("Login to your account title").located(By.cssSelector(".col-sm-4 .login-form h2"));
    public static Target LOGIN_TO_YOUR_ACCOUNT_ERROR = Target.the("Sign In button").located(By.cssSelector(".login-form p"));

}
