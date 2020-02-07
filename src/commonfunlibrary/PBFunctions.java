package commonfunlibrary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import constant.PBConstant;

public class PBFunctions extends PBConstant{
	/*ProjectName:Primus Bank
	 * Module Name:Admin login
	 * TesterName:Ranga
	 * Creation date:28/11/19
	 */
	public static boolean veiryfLogin(String username,String password)throws Throwable
	{
	driver.findElement(By.xpath(p.getProperty("objusername"))).sendKeys(username);
	driver.findElement(By.xpath(p.getProperty("objpassword"))).sendKeys(password);	
	driver.findElement(By.xpath(p.getProperty("objloginbtn"))).click();
	Thread.sleep(4000);
	String Expval="adminflow";
	String Actval=driver.getCurrentUrl();
	if(Actval.toLowerCase().contains(Expval.toLowerCase()))
	{
		Reporter.log("Login Success",true);
		return true;
	}
	else
	{
		Reporter.log("Login Fail",true);
		return false;	
	}
	
	}
	/*ProjectName:Primus Bank
	 * Module Name:Navigate branches
	 * TesterName:Ranga
	 * Creation date:28/11/19
	 */
	public static void navigateBranch()throws Throwable
	{
	driver.findElement(By.xpath(p.getProperty("objBranches"))).click();
	Thread.sleep(4000);
	}
	/*ProjectName:Primus Bank
	 * Module Name:Admin logout
	 * TesterName:Ranga
	 * Creation date:28/11/19
	 */
	public static boolean verifyLogout()throws Throwable
	{
driver.findElement(By.xpath(p.getProperty("objlogout"))).click();
Thread.sleep(4000);
if(driver.findElement(By.xpath(p.getProperty("objloginbtn"))).isDisplayed())
{
	Reporter.log("Logout Success",true);
	return true;
	
}
else
{
	Reporter.log("Logout Fail",true);
	return false;
}
	}
	/*ProjectName:Primus Bank
	 * Module Name:Branch Creation
	 * TesterName:Ranga
	 * Creation date:28/11/19
	 */	
public static boolean verifyBranchcreation(String bname,String address1,String zcode,
		int country,int state,int city)	throws Throwable
{
driver.findElement(By.xpath(p.getProperty("objnewbranch"))).click();
Thread.sleep(4000);
driver.findElement(By.xpath(p.getProperty("objbname"))).sendKeys(bname);
driver.findElement(By.xpath(p.getProperty("objadd1"))).sendKeys(address1);
driver.findElement(By.xpath(p.getProperty("objzcode"))).sendKeys(zcode);
new Select(driver.findElement(By.xpath(p.getProperty("objcountry")))).selectByIndex(country);
Thread.sleep(4000);
new Select(driver.findElement(By.xpath(p.getProperty("objstate")))).selectByIndex(state);
Thread.sleep(4000);
new Select(driver.findElement(By.xpath(p.getProperty("objcity")))).selectByIndex(city);
Thread.sleep(4000);
driver.findElement(By.xpath(p.getProperty("objsubmit"))).click();
Thread.sleep(4000);
String branchcreationalert=driver.switchTo().alert().getText();
Reporter.log(branchcreationalert,true);
Thread.sleep(4000);
driver.switchTo().alert().accept();
String Expval="new Branch";
if(branchcreationalert.toLowerCase().contains(Expval.toLowerCase()))
{
	Reporter.log("Branch Creation is success",true);
	return true;
}
else
{
	Reporter.log("Branch Creation is Fail",true);
	return false;
}
}
/*ProjectName:Primus Bank
 * Module Name:Branch Updation
 * TesterName:Ranga
 * Creation date:28/11/19
 */
public static boolean verifyBranchUpdation(String bname,String address1)throws Throwable
{
driver.findElement(By.xpath(p.getProperty("Obj_Click_Edit"))).click();	
Thread.sleep(4000);
driver.findElement(By.xpath(p.getProperty("Obj_Update_Bname"))).sendKeys(bname);
driver.findElement(By.xpath(p.getProperty("Obj_Update_Add1"))).sendKeys(address1);
driver.findElement(By.xpath(p.getProperty("Obj_Click_Update"))).click();
Thread.sleep(4000);
String branchupdationalert=driver.switchTo().alert().getText();
Reporter.log(branchupdationalert,true);
Thread.sleep(4000);
driver.switchTo().alert().accept();
String Expval="branch Updated";
if(branchupdationalert.toLowerCase().contains(Expval.toLowerCase()))
{
	Reporter.log("Branch updated is success",true);
	return true;
}
else
{
	Reporter.log("Branch updated is Fail",true);
	return false;
}
}
//for date generate
public static String generateDate()
{
	Date date=new Date();
	DateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_mm");
	return sdf.format(date);
}
}
