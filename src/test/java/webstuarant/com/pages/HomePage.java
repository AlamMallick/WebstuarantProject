package webstuarant.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//input[@id='searchval']")
    public WebElement searchTextBox;

    @FindBy(xpath = "//button[.='Search']")
    public WebElement searchButton;


}
