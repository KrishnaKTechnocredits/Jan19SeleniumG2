/*
 * Script for alert validation while doing Login
 */
package seleniumPractise.soumya;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

public class LoginAlert {
	// Method for validation of alerts in Login page fields
	public static void verifyLoginAlert() throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("URL Opened");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("Registration Clicked");
		Thread.sleep(3000);

		// Validation of alert when all fields are blank
		System.out.println("\n" + "Validation 1: Validation of alert when all fields are blank");
		System.out.println("Click on login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Login Button Clicked");
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Failed! please enter password")) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password field validation prompt is not correct");
		}

		// Validation of alert with password field blank
		System.out.println("\n" + "Validation 2: Validation of alert with password field blank");
		WebElement elementUn = driver.findElement(By.id("unameSignin"));
		elementUn.sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Login Button Clicked");
		driver.switchTo().alert();
		Thread.sleep(2000);
		if (alert.getText().equals("Failed! please enter password")) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password field validation prompt is not correct");
		}

		// Validation of alert with password less than 8 characters
		System.out.println("\n" + "Validation 3: Validation of alert with password less than 8 characters");
		elementUn.clear();
		driver.findElement(By.id("unameSignin")).sendKeys(prop.getProperty("username"));
		WebElement elementPw = driver.findElement(By.id("pwdSignin"));
		elementPw.sendKeys(prop.getProperty("passwordshortlt8"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Login Button Clicked");
		driver.switchTo().alert();
		Thread.sleep(2000);
		if (alert.getText().equals("Failed! please enter strong password")) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password field validation prompt is not correct");
		}

		// Validation of alert with password equal to 8 characters
		System.out.println("\n" + "Validation 4: Validation of alert with password equal to 8 characters");
		elementUn.clear();
		elementPw.clear();
		driver.findElement(By.id("unameSignin")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("pwdSignin")).sendKeys(prop.getProperty("passwordshorteq8"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Login Button Clicked");
		driver.switchTo().alert();
		Thread.sleep(2000);
		if (alert.getText().equals("Failed! please enter strong password")) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password field validation prompt is not correct");
		}

		// Validation of alert with password greater than 8 characters
		System.out.println("\n" + "Validation 5: Validation of alert with password greater than 8 characters");
		elementUn.clear();
		elementPw.clear();
		driver.findElement(By.id("unameSignin")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("pwdSignin")).sendKeys(prop.getProperty("passwordshortgt8"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Login Button Clicked");
		driver.switchTo().alert();
		Thread.sleep(2000);
		if (alert.getText().equals("Success!")) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password field validation prompt is not correct");
		}
		driver.close();
		System.out.println("\n" + "Verification Completed..Window Closed!!!");
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		verifyLoginAlert();
	}
}
