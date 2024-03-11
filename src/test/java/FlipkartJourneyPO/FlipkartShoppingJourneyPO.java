package FlipkartJourneyPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flipkart.base.CommonHelpers;

public class FlipkartShoppingJourneyPO {

	WebDriver driver;
	CommonHelpers helper;

	public FlipkartShoppingJourneyPO(WebDriver driver) {
		this.driver = driver;
		helper = new CommonHelpers(driver);
	}

	// This is our Page Object file where we are keeping our Functionality related
	// functions and Xpaths.

	public static final String searchField = "//input[@title='Search for Products, Brands and More']";
	public static final String result = "//span[contains(text(),\"Showing\")]/span";
	public static final String submitButton = "//button[@type=\"submit\"]";
	public static final String listOfItems = "//a[@rel='noopener noreferrer']";
	public static final String addToCartButton = "//button[text()='Add to cart']";
	public static final String buyNowButton = "//button[text()='Buy Now']";
	public static final String itemNameSearchList = "//div[@class='_4rR01T']";
	public static final String itemNameOnItemPage = "//h1/span";
	public static final String selectedItemValue = "//div[@class='CEmiEU']/div/div[@class='_30jeq3 _16Jk6d']";
	public static final String itemNameLableOnCartPage = "//a[@class='_2Kn22P gBNbID']";
	public static final String itemvalueOnCartpage = "//div[@class='_3fSRat']/span[@class='_2-ut7f _1WpvJ7']";
	public static final String itemTotalPrice = "//div[text()='Total Amount']/../..//div/div/span";

	String itemName;
	String itemValue;

	// Search product with return type of searched item Text
	public String searchProduct(String productValue) {
		helper.sendKeys(searchField, productValue);
		helper.clickElement(submitButton);
		helper.waitForElementToBeVisible(result);
		return helper.getText(result);
	}

	// Select first Item and storing Item Name and Value or price
	public boolean selectFirstItem(int value) throws InterruptedException {
		WebElement firstItem = helper.getListOfElements(listOfItems).get(value);
		WebElement firstItemName = helper.getListOfElements(itemNameSearchList).get(value);
		itemName = firstItemName.getText();

		firstItem.click();
		helper.switchToNewWindow();
		helper.waitForElementToBeVisible(addToCartButton);
		itemValue = helper.getText(selectedItemValue);

		return true;
	}

	// Add item into cart
	public boolean addSelectedItemToCart() throws InterruptedException {
		helper.clickElement(addToCartButton);
		return helper.waitForElementToBeVisible(itemNameLableOnCartPage);
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemValue() {
		return itemValue;
	}

	public String ItemNameOnCartPage() {
		return helper.getText(itemNameLableOnCartPage);
	}

	public String itemPriceOncartPage() {
		return helper.getText(itemvalueOnCartpage);
	}

	public String itemTotalPrice() {
		return helper.getText(itemTotalPrice);
	}
}
