package seleniumPractise.monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class AlertPractice1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");

		// 1) Alert Demo > Submit > Alert
		// Vaidation of the values of Alert Demo with of the Alert.
		// Basic elements link click
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic Elements link is click");
		Thread.sleep(2000);

		// Click Alert button
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		System.out.println("Clicked on alert");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");
		element.click();
		Alert alert = driver.switchTo().alert();
		String receivedAlert = alert.getText();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("Done");

		/// 2) Alert > Ok
		// Validate the string of Alert with hardcoded value.

		if ("You must be TechnoCredits student!!".equals(receivedAlert)) {
			System.out.println("Alert text and given text are matched");
		} else
			System.out.println("Alert text and given text are different");
	}

}
