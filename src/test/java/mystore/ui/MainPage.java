package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {
    public static final Target SECTION_LOGIN = Target.the("Login Section in main Page")
            .located(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a"));
    public static final Target SECTION_PRODUCTS = Target.the("Products Section in main Page")
            .located(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a"));
}
