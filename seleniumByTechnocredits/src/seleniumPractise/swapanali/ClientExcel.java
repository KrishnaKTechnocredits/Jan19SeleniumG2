package seleniumPractise.swapanali;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Init;


public class ClientExcel 
{
	WebDriver driver;
	@Test(dataProvider="loginData")
	public void doLogin(String Fullname,String Address,String EmailID,String City,String Company,String Username,String password,String RetypePwd,boolean Checkbox,String expectedResult) throws InterruptedException
	{
		driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath(".//a[text()='Registration']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Registration']")));
		driver.findElement(By.id("fullName")).sendKeys(Fullname);
		driver.findElement(By.id("address")).sendKeys(Address);
		driver.findElement(By.id("useremail")).sendKeys(EmailID);
		driver.findElement(By.id("usercity")).sendKeys(City);
		driver.findElement(By.id("organization")).sendKeys(Company);
		driver.findElement(By.id("usernameReg")).sendKeys(Username);
		driver.findElement(By.id("passwordReg")).sendKeys(password);
		driver.findElement(By.id("repasswordReg")).sendKeys(RetypePwd);
		if(Checkbox==true){
			driver.findElement(By.id("signupAgreement")).click();
		}
		Thread.sleep(3000);
		WebElement e1=driver.findElement(By.id("btnsubmitsignUp"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e1);
		e1.click();
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		alert.accept();
		
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(expectedResult);
	}

	@DataProvider(name="loginData")
	public Object[][] loginDataProvider () throws IOException 
	{
		ExcelSheetModular esm = new ExcelSheetModular("E:\\Swapnali\\Resources\\Registration.xlsx");
	
		
		 Object[][] data=esm.readData("SignUp");
		
		
		return data;
	}
	@AfterMethod
	public void teardown(){
		driver.close();
	}
	
}
