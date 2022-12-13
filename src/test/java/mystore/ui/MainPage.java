package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {
    public static final Target SECTION_LOGIN = Target.the("Login Section in main Page")
            .located(By.cssSelector("a[href='/login']"));

    public static final Target SECTION_PRODUCTS = Target.the("Products Section in main Page")
            .located(By.cssSelector("a[href='/products']"));
}