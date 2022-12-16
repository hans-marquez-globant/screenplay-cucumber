package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target EMAIL = Target.the("Email input").located(By.cssSelector("[data-qa='login-email']"));
    public static Target PASSWORD = Target.the("Password input").located(By.cssSelector("[data-qa='login-password']"));
    public static Target SIGN_IN_BUTTON = Target.the("Sign In button").located(By.cssSelector("[data-qa='login-button']"));
    public static Target LOGIN_TITLE = Target.the("Log In title").located(By.xpath("//h2[contains(text(),'Login to your account')]"));
    public static Target LOGIN_STATUS_FAILED = Target.the("Log In Status Failed").located(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));

}
