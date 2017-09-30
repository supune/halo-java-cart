package hautelook;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;


public class Stepdefs {

    private CheckoutService checkoutService = new CheckoutService();

    @Given("^I have an empty cart$")
    public void iHaveAnEmptyCart() throws Throwable {
        checkoutService.setCart(new Cart());
    }

    @Then("^My subtotal should be \"([^\"]*)\" dollars$")
    public void mySubtotalShouldBeDollars(int subtotal) throws Throwable {
        Assert.assertTrue("Total is " + subtotal,  checkoutService.getSubtotal() == subtotal);
    }

    @When("^I add a \"([^\"]*)\" dollar item named \"([^\"]*)\"$")
    public void iAddADollarItemNamed(int itemCost, String productName) throws Throwable {

        checkoutService.getCart().addItem(productName, (double)itemCost);
    }

    @Given("^I have a cart with a \"([^\"]*)\" dollar item named \"([^\"]*)\"$")
    public void iHaveACartWithADollarItemNamed(int itemCost, String productName) throws Throwable {
        iHaveAnEmptyCart();
        iAddADollarItemNamed(itemCost, productName);
    }

    @Then("^My quantity of products named \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void myQuantityOfProductsNamedShouldBe(String productName, int itemCount) throws Throwable {
        List<Item> itemsWithName = checkoutService.searchCartByName(productName);
        Assert.assertEquals(itemCount, itemsWithName.size());
    }

    @When("^I apply a \"([^\"]*)\" percent coupon code$")
    public void iApplyAPercentCouponCode(int percentOff) throws Throwable {

        checkoutService.setDiscount(new Discount("test", percentOff));

    }

    @When("^I add a \"([^\"]*)\" dollar \"([^\"]*)\" lb item named \"([^\"]*)\"$")
    public void iAddADollarItemWithWeight(int itemCost, int itemWeight, String productName) throws Throwable {
        checkoutService.addItemToCart(productName, itemCost, itemWeight);
    }

    @Then("^My total should be \"([^\"]*)\" dollars$")
    public void myTotalShouldBeDollars(int total) throws Throwable {

        Assert.assertEquals(total, checkoutService.getTotalWithShippingCost(),0);
    }
}
