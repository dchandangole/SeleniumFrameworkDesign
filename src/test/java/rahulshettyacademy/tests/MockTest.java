package rahulshettyacademy.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class MockTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://healthapp.yaksha.com/");

		// TC1-Locators
		By usernameTextbox = By.id("username_id");
		By passwordTextbox = By.id("password");
		By signInButton = By.cssSelector("button[type='submit']");
		By registeredPatientTextElement = By.xpath("//p[text()='Registered Patient ']");
		// TC2-Locators
		By billingNavigationMenuElement = By.linkText("Billing");
		By selectCounterPopupElement = By.cssSelector(".caption.custom-caption.no-margin");
		By new1TextElement = By.xpath("//h5[text()='New-1 ']");
		By new2TextElement = By.xpath("//h5[text()='New-2 ']");
		By new3TextElement = By.xpath("//h5[text()='New-3 ']");
		By old1TextElement = By.xpath("//h5[text()='Old-1 ']");
		By opdCounterTextElement = null;
		// TC3-Locators
		By addNewPatientTextElement = By.xpath("//div[@class='caption lb-caption']//*[text()='Add New Patient']");
		// TC 4&5 -Locators
		By firstNameTextFieldElement = By.id("newPatFirstName");
		By middleNameTextFieldElement = By.id("newPatMiddleName");
		By lastNameTextFieldElement = By.id("newPatLastName");
		By ageTextFieldElement = By.id("age");
		By contactNumberTextFieldElement = By.id("phoneNo");

		// TC6-Locators
		By countryDropdownByElement = By.id("ddlCountry");
		// TC7-Locators
		By closeBtn = By.cssSelector(".btn.btn-danger");
		By registerAndBillingButtonElement = By.id("registerNbilling");
		By errorMessageOfRegisterBillingByElement = By
				.xpath("//p[text()='Some of the inputs are invalid. Please check and try again. !']");
		// TC8&9-Locators
		By dispensaryToggle = By.xpath("//a[@href='#/Dispensary']");
		By prescriptionSubMenu = By.linkText("Prescription");
		By saleSubMenu = By.linkText("Sale");
		By stockSubMenu = By.linkText("Stock");
		By counterSubMenu = By.linkText("Counter");
		By reportsSubMenu = By.linkText("Reports");
		By patientConsumptionSubMenu = By.linkText("Patient Consumption");
		// TC10-Locators
		By dispensaryLeftNavigationMenu = By.xpath("//a[@href='#/Dispensary']");
		By settingLeftNavigationMenu = By.xpath("//a[@href='#/Settings']");

		/**
		 * 
		 * @Test1.1 about this method loginToHealthAppByGivenValidCredetail()
		 * 
		 * @param : Map<String, String>
		 * @description : fill usernameTextbox & passwordTextbox and click on sign in
		 *              button
		 * @return : Boolean
		 * @author : Yaksha
		 */
		String username = "admin";
		String password = "pass123";
		driver.findElement(usernameTextbox).sendKeys(username);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(signInButton).click();

		boolean result = driver.findElement(registeredPatientTextElement).isDisplayed();
//		return result;
		System.out.println(result);
		// --------------------------------------------------------------------------------------------------------------------//

		/**
		 * @Test1.2 about this method verifyTitleOfThePage()
		 * 
		 * @param : null
		 * @description : it will navigate to the URL and validate the title of the
		 *              current page.
		 * @return : String
		 * @author : Yaksha
		 */

		String pageTitle = driver.getTitle();
//		return pageTitle;
		System.out.println(pageTitle);
		// --------------------------------------------------------------------------------------------------------------------//

		/**
		 * @Test1.3 about this method verifyURLOFThePage()
		 * 
		 * @param : null
		 * @description : it will navigate to the URL and validate the URL of the
		 *              current page.
		 * @return : String
		 * @author : Yaksha
		 */

		String url = driver.getCurrentUrl();
//		return url;
		System.out.println(url);

		/*
		 * -----------------------------------------------------------------------------
		 * ------------------
		 */

		/**
		 * @test2 about this method
		 *        verifySelectCounterPopupIsPresentAndNavigateToNextpage()
		 * @param : null
		 * @description : it is verify all fields is present in current page or not
		 * @return : true
		 * @author : Yaksha
		 */

		WebElement billingMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(billingNavigationMenuElement));
		System.out.println("Billing menu is visible.");
		billingMenu.click();
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCounterPopupElement));
		boolean isPopUpPresent = popup.isDisplayed();
		driver.findElement(new1TextElement).click();
//		return isPopUpPresent;
		System.out.println("test 2 : " + isPopUpPresent);
		
		/*
		
		
		/*------------------------------------------------------------------------------------------------------------------*/
		/**
		 * @test3 about this method performKeyBoardOperationToOpenAddNewPatientPopup()
		 * @param : null
		 * @description : it will perform Key board operation (Alt+N) to open the Add
		 *              new patient page
		 * @return : String
		 * @author : Yaksha
		 */
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).perform();

		WebElement addNewPatientPopUp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(addNewPatientTextElement));
		String addNewPatientPopUpText = addNewPatientPopUp.getText();
//		return isAddNewPatientPopUp;
		System.out.println("test 3 : " + addNewPatientPopUpText);

		/*---------@test4---------------------------------------------------------------------------------------------------------*/

		boolean allPresent = true;
		allPresent &= driver.findElement(firstNameTextFieldElement).isDisplayed();
		allPresent &= driver.findElement(middleNameTextFieldElement).isDisplayed();
		allPresent &= driver.findElement(lastNameTextFieldElement).isDisplayed();
		allPresent &= driver.findElement(ageTextFieldElement).isDisplayed();
		allPresent &= driver.findElement(contactNumberTextFieldElement).isDisplayed();
//	    return allPresent;
		System.out.println("test 4 : " + allPresent);

//	    driver.findElement(firstNameTextFieldElement).sendKeys(expectedData.get("firstName"));
//	    driver.findElement(middleNameTextFieldElement).sendKeys(expectedData.get("middleName"));
//	    driver.findElement(lastNameTextFieldElement).sendKeys(expectedData.get("lastName"));
//	    driver.findElement(ageTextFieldElement).sendKeys(expectedData.get("age"));
//	    driver.findElement(contactNumberTextFieldElement).sendKeys(expectedData.get("contactNumber"));

		driver.findElement(firstNameTextFieldElement).sendKeys("firstName");
		driver.findElement(middleNameTextFieldElement).sendKeys("middleName");
		driver.findElement(lastNameTextFieldElement).sendKeys("lastName");
		driver.findElement(ageTextFieldElement).sendKeys("25");
		driver.findElement(contactNumberTextFieldElement).sendKeys("0000000000");

		/*---------@test5.1---------------------------------------------------------------------------------------------------------*/
//	    return driver.findElement(firstNameTextFieldElement).getAttribute("value");
		System.out.println("test 5.1 : " + driver.findElement(firstNameTextFieldElement).getAttribute("value"));

		/*---------@test5.2---------------------------------------------------------------------------------------------------------*/
//	    return driver.findElement(firstNameTextFieldElement).getAttribute("value");
		System.out.println("test 5.2 : " + driver.findElement(middleNameTextFieldElement).getAttribute("value"));

		/*---------@test5.3---------------------------------------------------------------------------------------------------------*/
//	    return driver.findElement(firstNameTextFieldElement).getAttribute("value");
		System.out.println("test 5.3 : " + driver.findElement(lastNameTextFieldElement).getAttribute("value"));

		/*---------@test5.4---------------------------------------------------------------------------------------------------------*/
//	    return driver.findElement(firstNameTextFieldElement).getAttribute("value");
		System.out.println("test 5.4 : " + driver.findElement(ageTextFieldElement).getAttribute("value"));

		/*---------@test5.5---------------------------------------------------------------------------------------------------------*/
//	    return driver.findElement(firstNameTextFieldElement).getAttribute("value");
		System.out.println("test 5.5 : " + driver.findElement(contactNumberTextFieldElement).getAttribute("value"));

		/*---------@test6---------------------------------------------------------------------------------------------------------*/
//	    String expectedCountry = expectedData.get("country");
		Select countryDropdown = new Select(driver.findElement(countryDropdownByElement));
		countryDropdown.selectByVisibleText("India");

		// Fetch the currently selected option and return its text
//	    return countryDropdown.getFirstSelectedOption().getText();
		System.out.println("test 6 : " + countryDropdown.getFirstSelectedOption().getText());

		/*---------@test7---------------------------------------------------------------------------------------------------------*/

		driver.findElement(closeBtn).click();
		actions.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).perform();
		WebElement addNewPatientPopUp2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(addNewPatientTextElement));
		driver.findElement(registerAndBillingButtonElement).click();
//		return driver.findElement(errorMessageOfRegisterBillingByElement).getText();
		System.out.println("test 7 : " + driver.findElement(errorMessageOfRegisterBillingByElement).getText());

		/*---------@test8---------------------------------------------------------------------------------------------------------*/
		driver.findElement(closeBtn).click();
		WebElement dispensaryToggleMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(dispensaryToggle));
		dispensaryToggleMenu.click();

		boolean allDisplayed = driver.findElement(prescriptionSubMenu).isDisplayed()
				&& driver.findElement(saleSubMenu).isDisplayed() && driver.findElement(stockSubMenu).isDisplayed()
				&& driver.findElement(counterSubMenu).isDisplayed() && driver.findElement(reportsSubMenu).isDisplayed()
				&& driver.findElement(patientConsumptionSubMenu).isDisplayed();

		System.out.println("test 8 : " + allDisplayed);
//	    return allDisplayed;

		/*---------@test9---------------------------------------------------------------------------------------------------------*/
		dispensaryToggleMenu.click();
		By dispensarySubMenu = By.xpath("//ul[@id='Dispensary' and contains(@class,'sub-menu')]");
		boolean isMinimized = wait
				.until(ExpectedConditions.attributeToBe(dispensarySubMenu, "class", "sub-menu collapse"));
		System.out.println("test 9 : " + isMinimized);
//		return isMinimized;

		/*---------@test10---------------------------------------------------------------------------------------------------------*/
		WebElement sidebarElement = driver.findElement(dispensaryLeftNavigationMenu);
		WebElement settings = driver.findElement(dispensaryLeftNavigationMenu);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", sidebarElement,
				settings);

		// 4. Check if 'Settings' is now in view (displayed & interactable)
		boolean isSettingsVisible = settings.isDisplayed()
				&& settings.getLocation().getY() >= sidebarElement.getLocation().getY();
		System.out.println("test 10 : " + isSettingsVisible);
//		return isSettingsVisible;
//		driver.quit();
		
	}
}
