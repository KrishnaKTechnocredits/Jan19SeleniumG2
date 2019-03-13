//below program is for validation alert text when password is greater than or equal to 8 characters

package seleniumPractise.purva;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment1_5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		Assignment1_5 obj1 = new Assignment1_5();
		obj1.passwordFieldValidation(driver);
		driver.close();
	}

	// method will navigate till password field and start validation on password
	// field
	public void passwordFieldValidation(WebDriver driver) throws InterruptedException {

		// clicked on registration page
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(1000);
		System.out.println("This is alert password program");

		// sending Purva to username field
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Purva");
		Thread.sleep(2000);
		// 1st input for password is blank
		String password0 = "";
		WebElement element = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		element.sendKeys(password0);
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Thread.sleep(2000);
		Alert alert0 = driver.switchTo().alert();
		String actualtextp0 = alert0.getText();
		String expectedtexp0 = "Failed! please enter password";
		if (password0.length() == 0) {
			if (actualtextp0.equals(expectedtexp0)) {
				System.out.println("Message 1: " + actualtextp0);
				Thread.sleep(500);
			}
		}
		Thread.sleep(500);
		alert0.accept();
		Thread.sleep(2000);

		// input 2 for password is equal to 7 characters which generated alert
		// as need strong password
		String password1 = "Purvahn";
		element.sendKeys(password1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		String actualtextp7 = alert1.getText();
		String expectedtexp7 = "Failed! please enter strong password";
		if (password1.length() < 8) {
			if (actualtextp7.equals(expectedtexp7)) {
				System.out.println("Message 2: " + actualtextp7);
				Thread.sleep(5000);
			}
		}

		alert1.accept();
		Thread.sleep(2000);

		// input 3 for password is equal to 8 characters which generated alert
		// as need strong password
		String password2 = "Purvahne";
		element.clear();
		Thread.sleep(2000);
		element.sendKeys(password2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		String actualtextp8 = alert2.getText();
		String expectedtexp8 = "Failed! please enter strong password";
		Thread.sleep(1000);
		if (password2.length() == 8) {
			Thread.sleep(1000);
			if (actualtextp8.equals(expectedtexp8)) {
				Thread.sleep(1000);
				System.out.println("Message 3: " + actualtextp8);
				Thread.sleep(5000);
			}
		}
		alert2.accept();
		Thread.sleep(2000);

		// input 4 for password is >8 characters which generated alert as
		// Success
		String password3 = "Purvahanchate";
		element.sendKeys(password3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Thread.sleep(2000);
		Alert alert3 = driver.switchTo().alert();
		String actualtextp9 = alert3.getText();
		Thread.sleep(2000);
		String expectedtexp9 = "Success!";
		if (password3.length() > 8) {
			if (actualtextp9.equals(expectedtexp9)) {
				System.out.println("Message 4: " + actualtextp9);
			}
		}
		alert3.accept();
	}
}
