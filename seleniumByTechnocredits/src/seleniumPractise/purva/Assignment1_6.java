//This program is to check validations on each field on registration functionality

package seleniumPractise.purva;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment1_6 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
		Assignment1_6 obj1 = new Assignment1_6();
		obj1.registrationFieldValidations(driver);
		Thread.sleep(1000);
		driver.close();
	}

	// below method will navigate to Registration and check validation on each
	// field of Registration functionality
	public void registrationFieldValidations(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(1000);

		WebElement element = driver
				.findElement(By.xpath("//button[@id='btnsubmitsignUp'][@class='btn btn-lg btn-login btn-block']"));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);

		// below code is first name input box and alert validation when first
		// name and all other fields are blank and we are clicking on submit
		// button
		element.click();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		String actual_text1 = alert1.getText();
		String expected_text1 = "Full name can't be blank";
		if (actual_text1.equals(expected_text1)) {
			System.out.println("Alert 1 actual and expected text match");
		}
		Thread.sleep(3000);
		alert1.accept();

		// entering numeric value in first name field and rest of the fields are
		// blank and we are clicking on submit button
		driver.findElement(By.cssSelector("input#fullName")).sendKeys("1");
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert2 = driver.switchTo().alert();
		String actual_text2 = alert2.getText();
		String expected_text2 = "Numeric value not allowed in fullname field";
		if (actual_text2.equals(expected_text2)) {
			System.out.println("Alert 2 actual and expected text match");
		}
		Thread.sleep(3000);
		alert2.accept();

		// Address input box and alert validation, here we are entering only
		// first name and address and rest all fields are blank and we are
		// clicking on submit button
		driver.findElement(By.cssSelector("input#fullName")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#fullName")).sendKeys("P");
		Thread.sleep(3000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert3 = driver.switchTo().alert();
		String actual_text3 = alert3.getText();
		String expected_text3 = "address cannot be blank";
		if (actual_text3.equals(expected_text3)) {
			System.out.println("Alert 3 actual and expected text match");
		}
		Thread.sleep(3000);
		alert3.accept();

		// ****email id input box and alert validation****
		// email id blank validation
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#fullName")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#fullName")).sendKeys("P");
		driver.findElement(By.cssSelector("input#address")).sendKeys("Aundh");
		Thread.sleep(2000);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert4 = driver.switchTo().alert();
		String actual_text4 = alert4.getText();
		String expected_text4 = "Please enter email id";
		if (actual_text4.equals(expected_text4)) {
			System.out.println("Alert 4 actual and expected text match");
		}
		Thread.sleep(3000);
		alert4.accept();

		// email id with @validation - entering p@ in email id field and first
		// name field has value rest all fields are blank and clicked on submit
		// button
		driver.findElement(By.cssSelector("input#useremail")).sendKeys("p@");
		Thread.sleep(2000);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert5 = driver.switchTo().alert();
		String actual_text5 = alert5.getText();
		String expected_text5 = "Please use correct email format";
		if (actual_text5.equals(expected_text5)) {
			System.out.println("Alert 5 actual and expected text match");
		}
		Thread.sleep(3000);
		alert5.accept();

		// email id with @ and com validation
		driver.findElement(By.cssSelector("input#useremail")).clear();
		driver.findElement(By.cssSelector("input#useremail")).sendKeys("p@com");
		Thread.sleep(3000);
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert6 = driver.switchTo().alert();
		String actual_text6 = alert6.getText();
		String expected_text6 = "Please use correct email format";
		if (actual_text6.equals(expected_text6)) {
			System.out.println("Alert 6 actual and expected text match");
		}
		Thread.sleep(3000);
		alert6.accept();

		// email id with input as @ and . validation
		driver.findElement(By.cssSelector("input#useremail")).clear();
		driver.findElement(By.cssSelector("input#useremail")).sendKeys("p@.com");
		Thread.sleep(3000);
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		js7.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert7 = driver.switchTo().alert();
		String actual_text7 = alert7.getText();
		String expected_text7 = "Please enter City";
		if (actual_text7.equals(expected_text7)) {
			System.out.println("Alert 7 actual and expected text match");
		}
		Thread.sleep(3000);
		alert7.accept();

		// ****city field validation with different input***
		// input 1 for city is -
		// input 2 for city is 90
		// input 3 for city is 90Pune
		// input 4 for city is Pune

		// below code is when we enter input 1 for city as -
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#usercity")).sendKeys("-");
		Thread.sleep(3000);
		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert8 = driver.switchTo().alert();
		String actual_text8 = alert8.getText();
		String expected_text8 = "Numeric not allowed in city/town field";
		if (actual_text8.equals(expected_text8)) {
			System.out.println("Alert 8 actual and expected text match");
		}
		Thread.sleep(3000);
		alert8.accept();

		// below code is when we enter input 2 for city as numeric value 90
		driver.findElement(By.cssSelector("input#usercity")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#usercity")).sendKeys("90");
		Thread.sleep(3000);
		JavascriptExecutor js9 = (JavascriptExecutor) driver;
		js9.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert9 = driver.switchTo().alert();
		String actual_text9 = alert9.getText();
		String expected_text9 = "Numeric not allowed in city/town field";
		if (actual_text9.equals(expected_text9)) {
			System.out.println("Alert 9 actual and expected text match");
		}
		Thread.sleep(3000);
		alert9.accept();

		// below code is when we enter input 3 for city as numeric value 90Pune
		driver.findElement(By.cssSelector("input#usercity")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#usercity")).sendKeys("90Pune");
		Thread.sleep(3000);
		JavascriptExecutor js10 = (JavascriptExecutor) driver;
		js10.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert10 = driver.switchTo().alert();
		String actual_text10 = alert10.getText();
		String expected_text10 = "Numeric not allowed in city/town field";
		if (actual_text10.equals(expected_text10)) {
			System.out.println("Alert 10 actual and expected text match");
		}
		Thread.sleep(3000);
		alert10.accept();

		// below code is when we enter input 4 for city as numeric value Pune
		driver.findElement(By.cssSelector("input#usercity")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#usercity")).sendKeys("Pune");
		Thread.sleep(3000);
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert11 = driver.switchTo().alert();
		String actual_text11 = alert11.getText();
		String expected_text11 = "Please enter your current organization";
		if (actual_text11.equals(expected_text11)) {
			System.out.println("Alert 11 actual and expected text match");
		}
		Thread.sleep(3000);
		alert11.accept();

		// below code is for Company Name/Student field it accepts all values
		// hence validation is checked with only 1 input
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#organization")).sendKeys("@CTS10");
		Thread.sleep(3000);
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert12 = driver.switchTo().alert();
		String actual_text12 = alert12.getText();
		String expected_text12 = "Username is mandatory field.";
		if (actual_text12.equals(expected_text12)) {
			System.out.println("Alert 12 actual and expected text match");
		}
		Thread.sleep(3000);
		alert12.accept();

		// selection radio button as female
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#radio-02")).click();
		Thread.sleep(3000);

		// ****username field validation****
		// input 1 = 10
		// input 2 = 10Pune

		// below code is for username input = 10
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#usernameReg")).sendKeys("10");
		Thread.sleep(3000);
		JavascriptExecutor js13 = (JavascriptExecutor) driver;
		js13.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert13 = driver.switchTo().alert();
		String actual_text13 = alert13.getText();
		String expected_text13 = "Username length should be greater then 5 characters.";
		if (actual_text13.equals(expected_text13)) {
			System.out.println("Alert 13 actual and expected text match");
		}
		Thread.sleep(3000);
		alert13.accept();

		// below code is for username input = 10Pune
		driver.findElement(By.cssSelector("input#usernameReg")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#usernameReg")).sendKeys("10Pune");
		Thread.sleep(3000);
		JavascriptExecutor js14 = (JavascriptExecutor) driver;
		js14.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert14 = driver.switchTo().alert();
		String actual_text14 = alert14.getText();
		String expected_text14 = "password is mandatory field.";
		if (actual_text14.equals(expected_text14)) {
			System.out.println("Alert 14 actual and expected text match");
		}
		Thread.sleep(3000);
		alert14.accept();

		// *** validation for password field***
		// input 1 for password = purva (password should be > 5 characters hence
		// it will generate alert
		// input 2 = purvah - here no alert generated as password>5 characters

		// input 1 = purva for password
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#passwordReg")).sendKeys("Purva");
		Thread.sleep(3000);
		JavascriptExecutor js15 = (JavascriptExecutor) driver;
		js15.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert15 = driver.switchTo().alert();
		String actual_text15 = alert15.getText();
		String expected_text15 = "password length should be greater then 5 characters.";
		if (actual_text15.equals(expected_text15)) {
			System.out.println("Alert 15 actual and expected text match");
		}
		Thread.sleep(3000);
		alert15.accept();

		// input 2 = purvah for password
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#passwordReg")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#passwordReg")).sendKeys("PurvaH");
		Thread.sleep(3000);
		JavascriptExecutor js16 = (JavascriptExecutor) driver;
		js16.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert16 = driver.switchTo().alert();
		String actual_text16 = alert16.getText();
		String expected_text16 = "password length should be greater then 5 characters.";
		if (actual_text16.equals(expected_text16)) {
			System.out.println("Alert 16 actual and expected text match");
		}
		Thread.sleep(3000);
		alert16.accept();

		// below code is for re-type password field where retype password field
		// value = purva does not match with password= purvah
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#repasswordReg")).sendKeys("Purva");
		Thread.sleep(3000);
		JavascriptExecutor js17 = (JavascriptExecutor) driver;
		js17.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert17 = driver.switchTo().alert();
		String actual_text17 = alert17.getText();
		String expected_text17 = "retype password donot match.";
		if (actual_text17.equals(expected_text17)) {
			System.out.println("Alert 17 actual and expected text match");
		}
		Thread.sleep(3000);
		alert17.accept();

		// below code is for re-type password field where retype password field
		// value = purvah matches with password= purvah
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#repasswordReg")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#repasswordReg")).sendKeys("PurvaH");
		Thread.sleep(3000);
		JavascriptExecutor js18 = (JavascriptExecutor) driver;
		js18.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Alert alert18 = driver.switchTo().alert();
		String actual_text18 = alert18.getText();
		String expected_text18 = "Please agree to terms of service and privacy policy";
		if (actual_text18.equals(expected_text18)) {
			System.out.println("Alert 18 actual and expected text match");
		}
		Thread.sleep(3000);
		alert18.accept();

		// below code is to check agreement checkbox and click on submit button
		// which generates success alert box
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("label.checkbox")).click();
		Thread.sleep(3000);
		element.click();
		Thread.sleep(2000);
		Alert alert19 = driver.switchTo().alert();
		String actual_text19 = alert19.getText();
		String expected_text19 = "Success";
		if (actual_text19.equals(expected_text19)) {
			System.out.println("Alert 19 actual and expected text match");
		}
		Thread.sleep(3000);
		alert19.accept();
	}

}
