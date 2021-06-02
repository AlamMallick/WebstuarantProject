package webstuarant.com.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webstuarant.com.utlities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultPage extends BasePage {



    @FindBy(xpath = " //li[@class='rc-pagination-next rc-pagination-disabled']/button[@type='button']")
    public WebElement nextPageButton;

    //li[@class='rc-pagination-next rc-pagination-disabled']/button[@type='button']
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
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", scrollDownPoint);

    }
    @FindBy(xpath = "//a[@class='rounded-r-md border-r hover:border-green-800 text-gray-800 hover:text-white hover:shadow-inner-green hover:bg-green-gradient border-gray-400 border-solid border border-r-0 box-border flex items-center justify-center font-semibold h-7-1/2 text-sm leading-none outline-none p-0 fill-current w-7-1/2 shadow-inner-white bg-gray-gradient']")
    public WebElement lastButton;


    public void allTextOfItems(){
        List<String> textOfItemss=new ArrayList<>();

        for (int i = 0; i <=productItem.size()-1 ; i++) {
            textOfItemss.add(productItem.get(i).getText());
            System.out.println(textOfItemss);
        }

    }

    public void nextPage(){
        List<String>allItems=new ArrayList<>();
        for (int i = 0; i <9 ; i++) {
scrollingDown();
            try {
                lastButton.click();
            } catch (Exception e) {
               e.getMessage();
            }
            allTextOfItems();



        }


    }



    public void clickTheLastElement() {
        allAddToCartButton.get(allAddToCartButton.size() - 1).click();
    }
}


