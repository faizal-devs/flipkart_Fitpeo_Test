package Flipkart_Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.BasePage;
import com.flipkart.base.BaseTest;

import FlipkartJourneyPO.FlipkartShoppingJourneyPO;

public class FlipkartTest extends BaseTest {

	BasePage basePage;
	FlipkartShoppingJourneyPO flipkartJourney;

	@BeforeMethod
	public void setupMethod() {
		basePage = new BasePage(getDriver());
		flipkartJourney = new FlipkartShoppingJourneyPO(getDriver());
	}

	@Test(priority = 1, description = "Flipkart Login Test")
	public void SearchProduct() throws InterruptedException {
		String searchvalue = "Mobile";

		// Searching an Item and verifying whether same item is being search or not
		Assert.assertEquals(flipkartJourney.searchProduct(searchvalue), searchvalue);
		// Selecting first Item from the searched item list or User can pass value and
		// decide
		Assert.assertEquals(flipkartJourney.selectFirstItem(1), true);
		// Adding Searched item into cart and verifying item present on the cart page.
		Assert.assertEquals(flipkartJourney.addSelectedItemToCart(), true);
		// Verifying Item Name on the cart which user has selected is the same or not
		Assert.assertEquals(flipkartJourney.ItemNameOnCartPage(), flipkartJourney.getItemName());
		// Verifying Item Price on the cart which user has selected is the same or not
		Assert.assertEquals(flipkartJourney.itemPriceOncartPage(), flipkartJourney.getItemValue());
		// Verifying Item total price on the cart which user has selected is the same or
		// not
		Assert.assertEquals(flipkartJourney.itemTotalPrice(), flipkartJourney.getItemValue());

		// Proceed to checkout can't be automated as of now because Do not have
		// authority to read real time OTP on real SIM (Which is required to login).
		// Can be automate If we have real time "flipkart" API's that generates OTP so
		// that we can read from the response and use for login.

	}

}
