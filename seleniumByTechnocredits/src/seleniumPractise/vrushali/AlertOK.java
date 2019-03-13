// Q2 Alert > Ok > Validate the string of Alert with hardcoded value.

package seleniumPractise.vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class AlertOK {

	public static void alertOkValidation(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		System.out.println("Basic element tab clicked");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[starts-with(@id,'javascriptAlert')]")).click();
		System.out.println("Alert button clicked");

		String expectedText = "You must be TechnoCredits student!!";
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Actual and expected text on Alert matched. Validation is passed");
		} else {
			System.out.println("Alert Validation failed");
		}
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		AlertOK.alertOkValidation(driver);
		driver.close();

	}
}
