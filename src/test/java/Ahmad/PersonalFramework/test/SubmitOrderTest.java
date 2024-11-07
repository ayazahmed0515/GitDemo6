package Ahmad.PersonalFramework.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Ahmad.PersonalFramework.TestComponents.BaseTest;
import AhmadPersonalFramework.PageObjects.CartPage;
import AhmadPersonalFramework.PageObjects.CheckoutPage;
import AhmadPersonalFramework.PageObjects.ConfirmationPage;
import AhmadPersonalFramework.PageObjects.LandingPage;
import AhmadPersonalFramework.PageObjects.OrderPage;
import AhmadPersonalFramework.PageObjects.ProductCataloguePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName="ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub
		
		//LandingPage landingPage=launchApplication();
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		LandingPage landingPage=new LandingPage(driver);
//		landingPage.goTo();
		ProductCataloguePage ProductCatalogue=landingPage.loginApplication("ayaz.ahmed0515@gmail.com", "Passw0rd");
		//ProductCataloguePage ProductCatalogue=new ProductCataloguePage(driver);
		List<WebElement> Products=ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
		CartPage cartPage=ProductCatalogue.goToCartPage();
		Boolean match=cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage =  cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCataloguePage ProductCatalogue=landingPage.loginApplication("ayaz.ahmed0515@gmail.com", "Passw0rd");
		OrderPage ordersPage=ProductCatalogue.goToOrdersPage();
	Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
	}

}
