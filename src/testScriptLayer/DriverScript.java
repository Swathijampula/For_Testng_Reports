package testScriptLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationLayer.AddEmpPage;
import applicationLayer.AddUserpage;
import applicationLayer.LoginPage;
import applicationLayer.LogoutPage;

public class DriverScript {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\New_Project\\CommonDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		//call login page
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		//call method
		login.verifyLogin("Admin", "Qedge123!@#");
	}
	@Test(priority =0,enabled=true)
	public void usercreation()throws Throwable
	{
	AddUserpage	user=PageFactory.initElements(driver, AddUserpage.class);
	user.verifyAdduser("Aarya Santhosh", "Seleniumhq123", "Akhilesh@1234", "Akhilesh@1234");
	}
	@Test(priority=1,enabled=true)
	public void empcreation()throws Throwable
	{
		AddEmpPage emp=PageFactory.initElements(driver, AddEmpPage.class);
		emp.verifyaddemp("testing", "selenium");
	}
	@AfterMethod
	public void tearDown()throws Throwable
	{
		LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
		logout.verifyLogout();
		driver.close();
	}

}
