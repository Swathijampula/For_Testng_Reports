package driverfactory;

import java.io.File;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonfunlibrary.PBFunctions;
import constant.PBConstant;
import utilities.ExcelFileUtil;

public class DriverScript extends PBConstant{
	String inputpath="E:\\Selenium\\New_Project\\TestInput\\Controller.xlsx"	;
	String outputpath="E:\\Selenium\\New_Project\\TestOutput\\keyword.xlsx";
	String TCSheet="TestCases";
	String TSSheet="TestSteps";
	File screen;
	ExtentReports report;
	ExtentTest test;
	@Test
	public void startTest()throws Throwable
	{
	report=new ExtentReports("./Reports//"+PBFunctions.generateDate()+"keyword.html");
	boolean res=false;
	String tcres="";
	//access xl util methods
	ExcelFileUtil xl=new ExcelFileUtil(inputpath);
	//Count no of rows in TCSheet
	int TCcount=xl.rowCount(TCSheet);
	//count no of rows in TSSheet
	int TScount=xl.rowCount(TSSheet);
	Reporter.log(TCcount+"   "+TScount);

	for(int i=1;i<=TCcount;i++)
	{
	//read excute column
	String execute=xl.getCellData(TCSheet, i, 2);	
	if(execute.equalsIgnoreCase("Y"))
	{
		//read tcid column from TCSHeet
	String tcid=xl.getCellData(TCSheet, i, 0);
	for(int j=1;j<=TScount;j++)
	{
	test=report.startTest("Keyword Framework");
		//read description column from TSSheet
		String Description=xl.getCellData(TSSheet, j, 2);
		//read tsid column from TSSHeet
	String tsid=xl.getCellData(TSSheet, j, 0);
	if(tcid.equalsIgnoreCase(tsid))
	{
		//read keyword column
		String keyword=xl.getCellData(TSSheet, j, 3);
	if(keyword.equalsIgnoreCase("AdminLogin"))
	{
	res=PBFunctions.veiryfLogin("Admin", "Admin");
	test.log(LogStatus.INFO, Description);
	}
	else if(keyword.equalsIgnoreCase("NewBranchCreation"))
	{
	PBFunctions.navigateBranch();
	res=PBFunctions.verifyBranchcreation("Kadiri", "Ananatapur", "12345", 1, 2, 1);
	test.log(LogStatus.INFO, Description);
	}
	else if(keyword.equalsIgnoreCase("UpdateBranch"))
	{
	PBFunctions.navigateBranch();
	res=PBFunctions.verifyBranchUpdation("kukatpalli", "Hyderabad");
	test.log(LogStatus.INFO, Description);
	}
	else if(keyword.equalsIgnoreCase("AdminLogout"))
	{
	res=PBFunctions.verifyLogout();
	test.log(LogStatus.INFO, Description);
	}
	String tsres="";
	if(res)
	{
		tsres="Pass";
		//write as pass in to results column in TSSheet
	xl.setCelldata(TSSheet, j, 4, tsres, outputpath);
	test.log(LogStatus.PASS, Description);
	}
	else
	{
	tsres="Fail";
	xl.setCelldata(TSSheet, j, 4, tsres, outputpath);
	test.log(LogStatus.FAIL, Description);
	}
	//if not tcres equal to null then write as pass or fail into  TCSheet
	if(!tsres.equalsIgnoreCase("Fail"))
	{
	tcres=tsres;
	}
	}
	report.endTest(test);
	report.flush();
	}
	xl.setCelldata(TCSheet, i, 3, tcres, outputpath);
	}
	else 
	{
	//write as  blocked in results column in TCSheet	
		xl.setCelldata(TCSheet, i, 3, "Blocked", outputpath);
	}
	}
	}


}
