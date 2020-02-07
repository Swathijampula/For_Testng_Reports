package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	Actions ac;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//store locators values
	@FindBy(name="txtUsername")
	WebElement objusername;
	@FindBy(css="#txtPassword")
	WebElement objpassword;
	@FindBy(id="btnLogin")
	WebElement objlogin;
	//method for login
	public void verifyLogin(String username,String password)
	{
	ac=new Actions(driver);
	objusername.sendKeys(username);
	objpassword.sendKeys(password);
	ac.moveToElement(objlogin).click().perform();
	}


}
