package seleniumPractise.monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class AlertPractice2 {

	// 3. javaScript Confirmation> Ok/Cancel > Message under the button
	// Validate the message with OK/Cancel.

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		// Basic elements link click
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic Elements link is click");
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//button[starts-with(@id,'javascriptConfi')]"));
		System.out.println("Clicked on Javascript confirmation alert");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");
		element.click();
		driver.switchTo().alert().accept();
		String ActualOkMessage = driver.findElement(By.id("pgraphdemo")).getText();

		if (ActualOkMessage.contains("You pressed OK!")) {
			System.out.println("Ok Button Validation done");
		}

		element.click();
		System.out.println("Click on JavaScript Execution Button Again");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		String ActualCancelMessage = driver.findElement(By.id("pgraphdemo")).getText();

		if (ActualCancelMessage.equals("You pressed Cancel!")) {
			System.out.println("Cancel Button validation done");
		}

	}

}
