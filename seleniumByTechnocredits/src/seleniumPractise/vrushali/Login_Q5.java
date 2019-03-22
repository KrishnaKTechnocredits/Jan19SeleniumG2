package seleniumPractise.vrushali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Login_Q5 {

	public static void main(String[] args) {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");

		Login_Q5.loginWhenPwdIsEmpty(driver);
		driver.quit();
	}

	public static void loginWhenPwdIsEmpty(WebDriver driver) {
		String username = "Vrushali";
		String password = "Test@1234"; // try giving blank password, password
										// length less than 8 character

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("registration2")).click();
		driver.findElement(By.id("unameSignin")).sendKeys(username);
		System.out.println("Username entered");

		driver.findElement(By.xpath("//input[@type='password'][1]")).sendKeys(password);
		System.out.println("Password entered");

		driver.findElement(By.id("rememberme")).click();

		System.out.println("Remember me checkbox is clicked");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (password.isEmpty()) {
			if (actualText.equals("Failed! please enter password")) {
				System.out.println("Password is empty, please enter valid password");
			}
		}

		if (password.length() <= 8) {
			if (actualText.equals("Failed! please enter strong password")) {
				System.out.println("Failed! please enter strong password");
			}
		}

		if (password.length() > 8) {
			if (actualText.equals("Success!")) {
				System.out.println("Password is correct.User logged in successfully");
			}
		}

		alert.accept();

	}

}
