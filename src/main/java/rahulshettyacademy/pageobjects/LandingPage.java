package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		//Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmailElement = driver.findElement(By.id("userEmail"));
// PageFactory - Design Pattern

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordElm;

	@FindBy(id = "login")
	WebElement submit;
	

	@FindBy(css = "[class*=flyInOut")
	WebElement errorMsg;
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordElm.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}	
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMsg);
		return errorMsg.getText();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
}
