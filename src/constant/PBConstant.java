package constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PBConstant {

public static WebDriver driver;
public static Properties p;
public static FileInputStream fi;
@BeforeMethod
public void setUp()throws Throwable
{
p=new Properties();
fi=new FileInputStream("E:\\Selenium\\New_Project\\PropertyFile\\Environment.properties");
p.load(fi);
if(p.getProperty("browser").equalsIgnoreCase("chrome"))
{
	System.out.println("Executing on chrome browser");
System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
driver=new ChromeDriver();
driver.get(p.getProperty("objurl"));
}
else if(p.getProperty("browser").equalsIgnoreCase("firefox"))
{
	System.out.println("Executing on firefox browser");
System.setProperty("wedriver.gecko.driver", "E:\\geckodriver.exe");
driver=new FirefoxDriver();
driver.get(p.getProperty("objurl"));
}
else
{
System.out.println("Browser is not matching");
}
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
