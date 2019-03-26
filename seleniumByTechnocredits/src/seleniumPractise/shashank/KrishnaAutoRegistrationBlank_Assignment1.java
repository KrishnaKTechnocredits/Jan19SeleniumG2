package seleniumPractise.shashank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Init;

public class KrishnaAutoRegistrationBlank_Assignment1 {

	static void scrollBar(WebDriver driver, WebElement e) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Work Docs\\Java\\Class\\3rd Weekend\\Eclipse\\resources\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://www.automationbykrishna.com/#");
		//driver.manage().window().maximize();
		KrishnaAutoRegistrationBlank_Assignment1 kar = new KrishnaAutoRegistrationBlank_Assignment1();
		kar.alertDemoValidation(driver);  //1st task of assignment
		kar.alertValidation(driver);   //2nd task of assignment
		kar.alertOkCancel(driver);   //3rd task of assignment
		kar.alertNameValidation(driver);   //4th task of assignment
		kar.submitButtonCheck(driver);   //5th and 6th task of assignment
		
	}	
	
	void alertDemoValidation(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("ufname")).sendKeys("Shashank");
		driver.findElement(By.name("ulname")).sendKeys("Garad");
		driver.findElement(By.name("cmpname")).sendKeys("ThoughtWorks");
		driver.findElement(By.xpath("//div[@id='indexBody']/section/div/div/section/div/div[4]//button[@type='submit'][@class='btn btn-primary']")).click();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		String expectedText = driver.findElement(By.name("ufname")).getAttribute("value")+" and "
				+driver.findElement(By.name("ulname")).getAttribute("value")+" and "
				+driver.findElement(By.name("cmpname")).getAttribute("value");
		//Thread.sleep(1000);
		System.out.println(actualText +"  ::  "+expectedText);
		if(expectedText.equals(actualText))
			System.out.println("Alert text is as expected");
		else
			System.out.println("Alert text is not as expected");	
	}
	
	void alertValidation(WebDriver driver) throws InterruptedException
	{
		String expectedText="You must be TechnoCredits student!!";
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement e=driver.findElement(By.id("javascriptAlert"));
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e);
		e.click();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		System.out.println(actualText +"  ::  "+expectedText);
		if(expectedText.equals(actualText))
			System.out.println("Alert text is as expected");
		else
			System.out.println("Alert text is not as expected");
	}
	
	void alertOkCancel(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement e=driver.findElement(By.id("javascriptConfirmBox"));
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e);
		e.click();
		driver.switchTo().alert().accept();
		if(driver.findElement(By.id("pgraphdemo")).getText().contains("OK"))
			System.out.println("Alert is accepted");
		e.click();
		driver.switchTo().alert().dismiss();
		if(driver.findElement(By.id("pgraphdemo")).getText().contains("Cancel"))
			System.out.println("Alert is dismissed");
	}
	
	void alertNameValidation(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement e=driver.findElement(By.id("javascriptPromp"));
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e);
		e.click();
		Alert al1 = driver.switchTo().alert();
		al1.sendKeys("Shanky");
		al1.accept();
		if(driver.findElement(By.id("pgraphdemo")).getText().equals("Hello Shanky! How are you today?"))
			System.out.println("Correct text is generated");
		else 
			System.out.println("Incorect text is generated");
		e.click();
		al1.dismiss();
		if(driver.findElement(By.id("pgraphdemo")).getText().equals("User cancelled the prompt."))
			System.out.println("Correct text is generated");
		else 
			System.out.println("Incorect text is generated");
		
	}
	
	void submitButtonCheck(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("registration2")).click();
		System.out.println("Clicked on Registration");
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.id("btnsubmitsignUp"));
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("fullName")).sendKeys("Shashank");
		System.out.println("Full name entered");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("address")).sendKeys("Balewadi");
		System.out.println("Address entered");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("useremail")).sendKeys("@.");
		System.out.println("email entered");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		System.out.println("City entered");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("organization")).sendKeys("IBM");
		System.out.println("Organization entered");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		driver.findElement(By.xpath("//label[@class='label_radio col-lg-6 col-sm-6' and @for='radio-01']")).click();
		System.out.println("Gender selected");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("usernameReg")).sendKeys("Shanky");
		System.out.println("Username entered");
		
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		WebElement e2=driver.findElement(By.id("passwordReg"));
		e2.sendKeys("pord");
		System.out.println("Password entered");
		
		if(e2.getAttribute("value").length()<=5)
		{
			KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
			e1.click();
			Alert al= driver.switchTo().alert();
			String altStr=al.getText();
			if(altStr.equals("password length should be greater then 5 characters."))
			{
				System.out.println("Alert text for short password is correct");
				al.accept();
				e2.sendKeys("password");
			}
			else
			{
				System.out.println("Alert text for short password is incorrect");
				al.accept();
				e2.sendKeys("password");
			}
		}
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		WebElement e3=driver.findElement(By.id("repasswordReg"));
		e3.sendKeys("pasword");
		System.out.println("Password re-entered");
		
		if(e2.getAttribute("value")!=e3.getAttribute("value"))
		{
			System.out.println("Renetered password does not match");
			KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
			e1.click();
			driver.switchTo().alert().accept();
			e3.clear();
			e3.sendKeys(e2.getAttribute("value"));
		}
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("signupAgreement")).click();
		System.out.println("Checked signupAgreement");
		
		KrishnaAutoRegistrationBlank_Assignment1.scrollBar(driver, e1);
		e1.click();
		driver.switchTo().alert().accept();
		driver.close();
	}
	
}
