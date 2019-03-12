package seleniumPractise.monali;

//prompt alert
//4) JavaScript Prompt > Name Entered > Message under the button Validate message with name.
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class AlertPractice3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		// Basic elements link click
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic Elements link is click");
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Monali");
		Thread.sleep(5000);
		System.out.println("send my name in alert");
		alert.accept();
		System.out.println("accepted alert");
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");
		element.click();
		driver.switchTo().alert().accept();
		String ActualOkMessage = driver.findElement(By.id("pgraphdemo")).getText();

		if (ActualOkMessage.contains("Monali")) {
			System.out.println("Actual String contains my name");
		}

		element.click();
		System.out.println("Click on JavaScript Prompt Button Again");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		String ActualCancelMessage = driver.findElement(By.id("pgraphdemo")).getText();

		if (ActualCancelMessage.contains("User cancelled the prompt.")) {
			System.out.println("Cancel Button validation done");
		}

	}

}
