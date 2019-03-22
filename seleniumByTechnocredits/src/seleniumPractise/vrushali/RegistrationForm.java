package seleniumPractise.vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class RegistrationForm {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[text()= 'Registration']")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.cssSelector("div[id= registration] h1")).getText().equals("Registration"))
			;
		System.out.println("Registration tab opened");

		RegistrationForm.nameFieldValidation(driver);
		// driver.quit();
	}

	public static void nameFieldValidation(WebDriver driver) throws InterruptedException {
		RegistrationForm.validation(driver);
		System.out.println("Alert popup generated");
		Thread.sleep(2000);
		Alert alertName = driver.switchTo().alert();
		String a1 = alertName.getText();
		alertName.accept();
		if (a1.equals("Full name can't be blank")) {
			System.out.println("Full name can't be blank, please enter full name");
		}

		driver.findElement(By.cssSelector("input[id ='fullName']")).sendKeys("Vrushali Poke");

		System.out.println("Full Name entered");

		// address field validation
		RegistrationForm.validation(driver);
		Alert alertAddress = driver.switchTo().alert();
		String a2 = alertAddress.getText();
		alertAddress.accept();

		if (a2.equals("address cannot be blank")) {
			System.out.println("address cannot be blank, please enter address");

		}
		driver.findElement(By.xpath("//input[@id ='fullName']/following-sibling::input[1]")).sendKeys("Balewadi");

		// validation for other email id

		RegistrationForm.validation(driver);
		Alert alertOtherEmail = driver.switchTo().alert();
		String a3 = alertOtherEmail.getText();
		alertOtherEmail.accept();

		if (a3.equals("Please enter email id")) {
			System.out.println("Please enter email id");

		}
		driver.findElement(By.xpath("//input[@id='useremail'][@name='useremail']")).sendKeys("vrusali@g.com");

		// validations for city
		RegistrationForm.validation(driver);
		Alert alertCity = driver.switchTo().alert();
		String a4 = alertCity.getText();
		alertCity.accept();

		if (a4.equals("Please enter City")) {
			System.out.println("Please enter City");
		}
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys("pune");

		// Validations for company name
		RegistrationForm.validation(driver);
		Alert alertCompany = driver.switchTo().alert();
		String a5 = alertCompany.getText();
		alertCompany.accept();

		if (a5.equals("Please enter your current organization")) {
			System.out.println("Organization can't be blank, Please enter your current organization");

		}
		driver.findElement(By.xpath("//input[@id='organization'] | //input[@name = 'organization']")).sendKeys("TCS");

		// Validations for radio button
		WebElement genderRadioButton = driver.findElement(By.xpath("//input[@id='radio-02']"));
		if (genderRadioButton.isDisplayed()) {
			if (!genderRadioButton.isSelected()) {
				genderRadioButton.click();
			}
		}

		// validation for User name

		RegistrationForm.validation(driver);
		Alert alertUserName = driver.switchTo().alert();
		String a6 = alertUserName.getText();
		alertUserName.accept();

		if (a6.equals("Username is mandatory field.")) {
			System.out.println("Username is mandatory field. Enter user name");
		}
		WebElement e1 = driver.findElement(By.id("usernameReg"));
		e1.clear();
		e1.sendKeys("Vrush");
		RegistrationForm.validation(driver);
		Alert alertUserName1 = driver.switchTo().alert();
		String a7 = alertUserName1.getText();
		alertUserName1.accept();

		if (a7.equals("Username length should be greater then 5 characters.")) {
			System.out.println("Username length should be greater then 5 characters.");
		}
		e1.clear();
		e1.sendKeys("Vrushali");
		RegistrationForm.validation(driver);
		Alert alertUserName2 = driver.switchTo().alert();
		String a8 = alertUserName2.getText();
		alertUserName2.accept();

		// validation for password field
		RegistrationForm.validation(driver);
		Alert alertPwd = driver.switchTo().alert();
		String a9 = alertUserName.getText();
		alertPwd.accept();

		if (a9.equals("password is mandatory field.")) {
			System.out.println("password is mandatory field.. Enter password");
		}

		WebElement pd = driver.findElement(By.id("passwordReg"));
		pd.clear();
		pd.sendKeys("test");

		RegistrationForm.validation(driver);
		Alert alertPwd1 = driver.switchTo().alert();
		String a10 = alertUserName1.getText();
		alertPwd1.accept();

		if (a10.equals("password length should be greater then 5 characters.")) {
			System.out.println("password length should be greater then 5 characters.");
		}
		pd.clear();
		pd.sendKeys("Password");
		RegistrationForm.validation(driver);
		Alert alertPwd3 = driver.switchTo().alert();
		String a11 = alertUserName2.getText();
		alertPwd3.accept();

		// validation for re-enter password
		RegistrationForm.validation(driver);
		Alert alertRePwd = driver.switchTo().alert();
		String a12 = alertUserName.getText();
		alertRePwd.accept();

		if (a12.equals("please reenter password")) {
			System.out.println("please reenter password");
		}

		WebElement rePswd = driver.findElement(By.id("repasswordReg"));
		rePswd.clear();
		rePswd.sendKeys("test");

		RegistrationForm.validation(driver);
		Alert alertRePwd2 = driver.switchTo().alert();
		String a13 = alertUserName1.getText();
		alertRePwd2.accept();

		if (a13.equals("retype password donot match.")) {
			System.out.println("retype password donot match.");
		}

		rePswd.clear();
		rePswd.sendKeys("Password");

		RegistrationForm.validation(driver);
		Alert alertRePwd3 = driver.switchTo().alert();
		String a14 = alertUserName2.getText();
		alertRePwd3.accept();

		RegistrationForm.validation(driver);
		Alert alert = driver.switchTo().alert();
		String al = alert.getText();
		alert.accept();

		if (al.equals("Please agree to terms of service and privacy policy")) {
			System.out.println("Please agree to terms of service and privacy policy");
		}

		driver.findElement(By.id("signupAgreement")).click();
		System.out.println("Checkbox selected");
	}

	public static void validation(WebDriver driver) {

		WebElement tick = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tick);
		tick.click();

	}
}
