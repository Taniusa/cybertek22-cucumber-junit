package com.cybertek.step_definitions;

import com.cybertek.pages.AmazonPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.OfficeHoursUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchStepDefs {
    AmazonPage amazon;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    double singlePriceForHat;
    Select selectQuantity;

    @Given("User is on the Amazon Home Page")
    public void user_is_on_the_amazon_home_page() {
        //opening page
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));
        BrowserUtils.sleep(1);
        //creating object to reach POM variables and methods


    }
    @When("User search for hats for men")
    public void user_search_for_hats_for_men() {
        // Write code here that turns the phrase above into concrete actions
        amazon = new AmazonPage();
        amazon.searchBox.sendKeys(ConfigurationReader.getProperty("searchAmazon")+ Keys.ENTER);
    }
    @When("User ads the first hat appearing to the cart with quantity two")
    public void user_ads_the_first_hat_appearing_to_the_cart_with_quantity_two() {
        // Write code here that turns the phrase above into concrete actions
        wait.until((ExpectedConditions.elementToBeClickable(amazon.firstHat)));
        amazon.firstHat.click();
        String priceText = amazon.price.getText();
        singlePriceForHat = OfficeHoursUtils.priceConverter(priceText);

        //selected quantity
        selectQuantity = new Select(amazon.quantityDropDown);
        selectQuantity.selectByVisibleText("2");

        //add to cart
        amazon.addToCartButton.click();

    }

    @Then("the total price and quantiy should be correct")
    public void the_total_price_and_quantiy_should_be_correct() {
        //check cart
        amazon.cart.click();
        Assert.assertTrue(amazon.subTotalText.getText().contains("2 items"));

    }
    @When("user reduce the quantity from two to one")
    public void user_reduce_the_quantity_from_two_to_one() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("total price and quantity has been correctly changed")
    public void total_price_and_quantity_has_been_correctly_changed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
