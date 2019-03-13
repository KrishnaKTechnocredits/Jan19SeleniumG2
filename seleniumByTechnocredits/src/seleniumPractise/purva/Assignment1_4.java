//Program to check validation on clicking Javascript prompt button under section "DIFFERENT EXAMPLES OF ALERTS" on "Basic Elements" page

package seleniumPractise.purva;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment1_4 {

	static String name = "Purva Hanchate";

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Assignment1_4 obj1 = new Assignment1_4();
		obj1.pageToButtonNavigation(driver);
		obj1.javascriptpromptOkButton(driver);
		obj1.javascriptpromptCancelButton(driver);
		Thread.sleep(2000);
		driver.quit();
	}

	// this method will click on URL and basic elements menu option
	public void pageToButtonNavigation(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		// clicked on basic elements button
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(400);
	}

	// this method is for validation of text on clicking Ok button on alert
	public void javascriptpromptOkButton(WebDriver driver) throws InterruptedException {
		// element stores xpath for Javascript prompt button
		WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-12']//button[@id='javascriptPromp']"));
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(1000);
		element.click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.sendKeys(name);
		Thread.sleep(1500);
		alert1.accept();
		String actualmsgonOK = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedmsgonOK = "Hello " + name + "! How are you today?";
		System.out.println("Expected message: " + expectedmsgonOK);
		System.out.println("Actual message: " + actualmsgonOK);
		if (expectedmsgonOK.equals(actualmsgonOK))
			System.out.println("Message match on click of Ok button");
		System.out.println();
	}

	// this method is for validation of text on clicking Cancel button on alert
	public void javascriptpromptCancelButton(WebDriver driver) throws InterruptedException {
		// again clicked on Javascript prompt button
		driver.findElement(By.xpath("//div[@class='col-lg-12']//button[@id='javascriptPromp']")).click();
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(1000);
		alert2.sendKeys(name);
		Thread.sleep(1500);
		alert2.dismiss();
		Thread.sleep(2000);
		String actualmsgonCan = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedmsgonCan = "User cancelled the prompt.";
		System.out.println("Expected message: " + expectedmsgonCan);
		System.out.println("Actual message: " + actualmsgonCan);
		if (expectedmsgonCan.equals(actualmsgonCan))
			System.out.println("Message match on click of Cancel button");
		System.out.println();
	}
}
