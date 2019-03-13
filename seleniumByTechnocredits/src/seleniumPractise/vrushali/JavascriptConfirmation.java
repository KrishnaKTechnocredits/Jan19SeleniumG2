//javaScript Confirmation> Ok/Cancel > Validate the message shown below button with OK/Cancel action.

package seleniumPractise.vrushali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class JavascriptConfirmation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		JavascriptConfirmation.JavascriptConfirmationOK(driver);
		JavascriptConfirmation.JavascriptConfirmationCancel(driver);
		driver.close();

	}

	// Method to validate message after accepting (OK) javaScript Confirmation
	// alert
	public static void JavascriptConfirmationOK(WebDriver driver) throws InterruptedException {

		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		System.out.println("Basic element tab clicked");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox' ][@type='submit']")).click();
		System.out.println("Javascript Confirmation button clicked");

		driver.switchTo().alert().accept();
		System.out.println("Control switched to alert and OK button on alert is clicked");

		String actualOKText = driver.findElement(By.xpath("//p[text()= 'You pressed OK!']")).getText();
		if (actualOKText.equals("You pressed OK!")) {
			System.out.println("OK button validation passed");
		} else {
			System.out.println("OK button validation failed");
		}

	}

	// Method to validate message after dismissing (Cancel) javaScript
	// Confirmation alert
	public static void JavascriptConfirmationCancel(WebDriver driver) throws InterruptedException {

		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		System.out.println("Basic element tab clicked");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox' ][@type='submit']")).click();
		System.out.println("Javascript Confirmation button clicked");

		driver.switchTo().alert().dismiss();
		;
		System.out.println("Control switched to alert and alert is dismissed");

		String actualOKText = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		if (actualOKText.equals("You pressed Cancel!")) {
			System.out.println("Cancel button validation passed");
		} else {
			System.out.println("Cancel button validation failed");
		}

	}

}
