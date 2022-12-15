package mystore.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyAccountPage {
    public static final Target LOGIN_STATUS = Target.the("My login status")
            .located(By.xpath("//*[text()=' Logged in as ']"));
    public static final Target FAILED_LOGIN_STATUS = Target.the("My login status")
            .located(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
    public static final Target LOGIN_TITLE = Target.the("Login Title")
            .located(By.xpath("//h2[contains(text(),'Login to your account')]"));
}
