package webstuarant.com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webstuarant.com.utlities.Driver;

import java.util.List;

public class ResultPage extends BasePage {


    @FindBy(xpath = "//div[@id='product_listing']//a[contains(@class, \"description\")]")
    public List<WebElement> productItem;


    @FindBy(xpath = "//input[starts-with(@name,\"addToCartButton\")]")
    public List<WebElement> allAddToCartButton;


    @FindBy(xpath = " //p[.='Related Searches']")
    public WebElement scrollDownPoint;

    public void assertingTable() {
        List<WebElement> descriptions = productItem;
        for (WebElement each : descriptions) {
            Assert.assertTrue("Missing the table from description ", each.getText().contains("Table"));
        }
    }

    public void scrollingDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(scrollDownPoint).perform();
    }

    public void clickTheLastElement() {
        allAddToCartButton.get(allAddToCartButton.size() - 1).click();
    }
}


