package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddUserpage {
	WebDriver driver;
	Actions ac;
	public AddUserpage(WebDriver driver)
	{
		this.driver=driver;
	}
	//define locators
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement objadmin;
	@FindBy(id="menu_admin_UserManagement")
	WebElement objusermngnt;
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement objusers;
	@FindBy(id="btnAdd")
	WebElement objadd;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement objename;
	@FindBy(id="systemUser_userName")
	WebElement objusername;
	@FindBy(id="systemUser_password")
	WebElement objpassword;
	@FindBy(id="systemUser_confirmPassword")
	WebElement objcpassword;
	@FindBy(id="btnSave")
	WebElement objsave;
	public void verifyAdduser(String ename,String username,String password,String cpassword)
	throws Throwable{
	ac=new Actions(driver);
	ac.moveToElement(objadmin).perform();
	Thread.sleep(3000);
	ac.moveToElement(objusermngnt).perform();
	Thread.sleep(3000);
	ac.moveToElement(objusers).click().perform();
	Thread.sleep(3000);
	ac.moveToElement(objadd).click().perform();
	Thread.sleep(3000);
	objename.sendKeys(ename);
	objusername.sendKeys(username);
	objpassword.sendKeys(password);
	objcpassword.sendKeys(cpassword);
	ac.moveToElement(objsave).click().perform();
	Thread.sleep(5000);
	}

}
