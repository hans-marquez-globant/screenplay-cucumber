package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {
    public static Target SECTION_LOGIN = Target.the("Login Section in main Page")
            .located(By.className("fa-lock"));
}
