package webstuarant.com.pages;

import org.openqa.selenium.support.PageFactory;
import webstuarant.com.utlities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
