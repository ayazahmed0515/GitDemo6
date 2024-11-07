package Ahmad.PersonalFramework.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Ahmad.PersonalFramework.TestComponents.BaseTest;
import AhmadPersonalFramework.PageObjects.CartPage;
import AhmadPersonalFramework.PageObjects.ProductCataloguePage;

public class ErrorValidation extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		ProductCataloguePage ProductCatalogue=landingPage.loginApplication("ayaz.ahmed0515@gmail.com", "Passwrd");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() {
	
	String productName="ZARA COAT 33";
	ProductCataloguePage ProductCatalogue=landingPage.loginApplication("ayaz.ahmed0515@gmail.com", "Passw0rd");
	//ProductCataloguePage ProductCatalogue=new ProductCataloguePage(driver);
	List<WebElement> Products=ProductCatalogue.getProductList();
	ProductCatalogue.addProductToCart(productName);
	CartPage cartPage=ProductCatalogue.goToCartPage();
	Boolean match=cartPage.VerifyProductDisplay(productName);
	Assert.assertFalse(match);

}
}
