package AhmadPersonalFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AhmadPersonalFramework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	// WebElement userEmail= driver.findElement(By.id("userEmail"));
	//	driver.findElement(By.id("userPassword"));
	//	driver.findElement(By.id("login"));
	 @FindBy(id="userEmail")
	 WebElement userEmail;
	 
	 @FindBy(id="userPassword")
	 WebElement userPassword;
	 
	 @FindBy(css=".login-btn")
	 WebElement submit;
	 
	 @FindBy(css="[class*=ng-star-inserted]")
	 WebElement errorMessage;
	 
	 public ProductCataloguePage loginApplication(String email, String pwd) {
		 userEmail.sendKeys(email);
		 userPassword.sendKeys(pwd);
		 submit.click();
		 ProductCataloguePage ProductCatalogue=new ProductCataloguePage(driver);
		 return ProductCatalogue;
	 }
	 
	 public void goTo()
	 {
		 driver.get("https://rahulshettyacademy.com/client");
}
	 
	 public String getErrorMessage() {
		 waitForWebElementToAppear(errorMessage);
		 return  errorMessage.getText();
		 
	 }
	 
	 
}

