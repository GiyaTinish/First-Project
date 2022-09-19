package Pages_Pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbLoginPage {
	WebDriver driver;

	By fbEmail = By.id("email");
	By fbPassword = By.id("pass");
	By fbLogin = By.name("login");
	
	public FbLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setValues(String userName,String password)
	{
		driver.findElement(fbEmail).clear();
		driver.findElement(fbPassword).clear();
		driver.findElement(fbEmail).sendKeys(userName);
		driver.findElement(fbPassword).sendKeys(password);
	}
	
	public void login()
	{
		driver.findElement(fbLogin).click();
	}
	
}
