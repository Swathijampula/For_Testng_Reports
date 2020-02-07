package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmpPage {
	WebDriver driver;
	Actions ac;
	public AddEmpPage(WebDriver driver)

	{
		this.driver=driver;
	}
	@FindBy(id="menu_pim_viewPimModule")
	WebElement objPim;
	@FindBy(id="btnAdd")
	WebElement objadd;
	@FindBy(id="firstName")
	WebElement objfname;
	@FindBy(id="lastName")
	WebElement objlname;
	@FindBy(id="btnSave")
	WebElement objsave;
	public void verifyaddemp(String fname,String lname)throws Throwable
	{
		ac=new Actions(driver);
		ac.moveToElement(objPim).click().perform();
		Thread.sleep(4000);
		ac.moveToElement(objadd).click().perform();
		Thread.sleep(4000);
		objfname.sendKeys(fname);
		objlname.sendKeys(lname);
		ac.moveToElement(objsave).click().perform();
		Thread.sleep(4000);
	}


}
