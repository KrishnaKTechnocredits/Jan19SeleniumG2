package seleniumPractise.shashank;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Init;

public class ClientExcel {
	
	WebDriver driver=null;
	
	void scroll(WebElement e)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",e);
	}
	
	@BeforeMethod
	void beforeRegistration()
	{
		this.driver = Init.start();
		driver.get("http://www.automationbykrishna.com/#");
	}
	
	@Test (dataProvider="loginDataProv")
	void registration(String fname, String add, String email, String city, String cname, String uname, String pass, String rpass, String termFlag, String expResult)
	{
		driver.findElement(By.cssSelector("#registration2")).click();
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#fullName")));
		
		WebElement e1=driver.findElement(By.cssSelector("#fullName"));
		scroll(e1);
		e1.sendKeys(fname);
		WebElement e2=driver.findElement(By.cssSelector("#address"));
		scroll(e2);
		e2.sendKeys(add);
		WebElement e3=driver.findElement(By.cssSelector("#useremail"));
		scroll(e3);
		e3.sendKeys(email);
		WebElement e4=driver.findElement(By.cssSelector("#usercity"));
		scroll(e4);
		e4.sendKeys(city);
		WebElement e5=driver.findElement(By.cssSelector("#organization"));
		scroll(e5);
		e5.sendKeys(cname);
		WebElement e6=driver.findElement(By.cssSelector("#usernameReg"));
		scroll(e6);
		e6.sendKeys(uname);
		WebElement e7=driver.findElement(By.cssSelector("#passwordReg"));
		scroll(e7);
		e7.sendKeys(pass);
		WebElement e8=driver.findElement(By.cssSelector("#repasswordReg"));
		scroll(e8);
		e8.sendKeys(rpass);
		if(termFlag.equals("yes"))
		{
			WebElement e9=driver.findElement(By.cssSelector("#signupAgreement"));
			scroll(e9);
			e9.click();
		}
		WebElement e10=driver.findElement(By.cssSelector("#btnsubmitsignUp"));
		scroll(e10);
		e10.click();
		
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		
		Assert.assertEquals(actualText, expResult);
	}
	
	@DataProvider (name="loginDataProv")
	Object[][] loginDataProvider() throws IOException
	{
		ExcelSheetReading asra = new ExcelSheetReading("C:\\Work Docs\\Java\\Selenium\\HomeWork_TestNG_17March2019.xlsx");
		Object data[][]=asra.readExcel("Registration_Data", true);
		return data;
	}
	
	@AfterMethod()
	void afterRegistration()
	{
		driver.close();
	}
}
