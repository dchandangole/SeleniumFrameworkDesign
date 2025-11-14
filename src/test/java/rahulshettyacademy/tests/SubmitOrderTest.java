package rahulshettyacademy.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {


	@Test(dataProvider = "getData", groups = "Purchase", retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String, String> input) throws IOException {
		// TODO Auto-generated method stub
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String cofirmMsg = confirmationPage.getConfirmationMsg();
		Assert.assertTrue(cofirmMsg.equalsIgnoreCase("Thankyou for the order."));
		System.out.println("Order Placed!");

	}

//	@Test(dependsOnMethods = { "submitOrder" })
//	public void OrderHistoryTest() {
//		ProductCatalogue productCatalogue = landingPage.loginApplication("test13oup@gmail.com", "Admin@12345");
//		OrderPage orderPage = productCatalogue.goToOrderPage();
//		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
//		System.out.println("Proudct verified!");
//	}

	@DataProvider
	public Object[][]getData() throws IOException {
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "test13oup@gmail.com");
//		map.put("password", "Admin@12345");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "test13oup@gmail.com");
//		map1.put("password", "Admin@12345");
//		map1.put("productName", "ADIDAS ORIGINAL");
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};

	}
	

}



