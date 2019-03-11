package seleniumPractise.swapanali;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class Q6_registration_Msg {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver= Init.initChromeDriver();	
		registraion_Validation(driver);
		driver.close();
	}
	public static void registraion_Validation(WebDriver driver) throws IOException, InterruptedException{
		Properties prop=PropFileOperation.loadProp();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[contains(@id,'registration2')]")).click();
		Thread.sleep(3000);
		
		System.out.println("Registration window");
		WebElement e1=driver.findElement(By.xpath("//button[@id='btnsubmitsignUp'and @class='btn btn-lg btn-login btn-block']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		
		//fullname validation
		if(prop.getProperty("fullname").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			
		}
		else{
			driver.findElement(By.xpath("//input[@class='form-control' and @id='fullName']")).sendKeys(prop.getProperty("fullname"));					
		}	
		//address validation
		if(prop.getProperty("address").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());//
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[contains(@id,'address')]")).sendKeys(prop.getProperty("address"));			
		}
		//Email validation
		
		if(prop.getProperty("email").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[starts-with(@id,'useremail')]")).sendKeys(prop.getProperty("email"));			
		}
		
	//City validation  
		if(prop.getProperty("city").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[@id='usercity' and @class='form-control']")).sendKeys(prop.getProperty("city"));			
		}
		//company name validation
		if(prop.getProperty("company").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[@id='organization' and @class='form-control']")).sendKeys(prop.getProperty("company"));			
		}
		//Username validation
		if(prop.getProperty("username").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[contains(@id,'usernameReg')]")).sendKeys(prop.getProperty("username"));			
		}
		//password validation		
		if(prop.getProperty("password").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else if(prop.getProperty("password").length()<8){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[contains(@id,'passwordReg')]")).sendKeys(prop.getProperty("password"));			
		}
		//retype password
		
		if(prop.getProperty("retypepwd").trim().isEmpty()){
			js.executeScript("arguments[0].scrollIntoView(true)", e1);
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		else{
			driver.findElement(By.xpath("//input[contains(@id,'repasswordReg')]")).sendKeys(prop.getProperty("retypepwd"));		
			
		}
		
		WebElement aggrement=driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		aggrement.click();
		if(aggrement.isSelected()==false){
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
		}
		else{
			e1.click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}
}
