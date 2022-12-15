package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {
    //SECTION_LOGIN es el selector
    public static final Target SECTION_LOGIN = Target.the("Login Section in main Page")
            .located(By.xpath("//*[@class='nav navbar-nav']//*[text()=' Signup / Login']"));

    //SECTION_PRODUCTS es el selector
    public static final Target SECTION_PRODUCTS = Target.the("Products Section in main Page")
            .located(By.xpath("//*[@class='nav navbar-nav']//*[text()=' Products']"));
}
