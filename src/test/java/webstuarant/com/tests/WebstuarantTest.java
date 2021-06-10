package webstuarant.com.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import webstuarant.com.pages.CartPage;
import webstuarant.com.pages.CheckoutPage;
import webstuarant.com.pages.HomePage;
import webstuarant.com.pages.ResultPage;
import webstuarant.com.utlities.ConfigurationReader;
import webstuarant.com.utlities.Driver;

import java.util.List;

import static webstuarant.com.utlities.BrowserUtils.waitUntilVisible;


public class WebstuarantTest {

    static HomePage homePage = new HomePage();
    static ResultPage searchPage = new ResultPage();
    static CartPage cartPage = new CartPage();
    static CheckoutPage checkoutPage = new CheckoutPage();

    @Before
    public void setup() {



        //Getting the url from properties
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }


    @Test
    public void testSteps()  {




        //searching the requested item
        homePage.searchTextBox.sendKeys("stainless work table", Keys.ENTER);



        // asserting the title contains table
        searchPage.assertingTable();


        //hovering over to last item
        searchPage.scrollingDown();
        searchPage.lastButton.click();
        searchPage.nextPage();


        //clicking the last item on the current page
        searchPage.clickTheLastElement();


        //viewing the cart
        cartPage.viewCart.click();


        //emptying the cart
        checkoutPage.emptyCartButton.click();


        //applying explicit waits
        checkoutPage.waitAndClick();
        checkoutPage.waitForText();


        //Asserting the cart is empty
        Assert.assertEquals(checkoutPage.emptyCartHeader.getText(), "Your cart is empty.");


    }


    @After
    public void tearDown() {
        //closing the driver
Driver.closeDriver();

    }


}
