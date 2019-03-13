//Program to check validation on clicking Javascript confirmation button under section "DIFFERENT EXAMPLES OF ALERTS" on "Basic Elements" page

package seleniumPractise.purva;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment1_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Assignment1_3 obj1 = new Assignment1_3();
		obj1.pageToButtonNavigation(driver);
		obj1.okButtonValidation(driver);
		obj1.cancelButtonValidation(driver);
		Thread.sleep(1500);
		driver.close();
	}

	// this method will click on URL and basic elements menu option
	public void pageToButtonNavigation(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(400);
	}

	// this method is for validation of text on clicking on Ok button on Alert
	public void okButtonValidation(WebDriver driver) throws InterruptedException {
		// element storing xpath for Javascript confirmation button
		WebElement element = driver.findElement(By.xpath("//div[@class='row'][2]//following::button[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept(); // clicked on Ok on alert
		String actualmsg = driver.findElement(By.xpath("//*[contains(@id,'pgraphdemo')]")).getText();
		String expectedmsg = "You pressed OK!";
		System.out.println("OK button actual text: " + actualmsg);
		System.out.println("OK button expected text: " + expectedmsg);
		if (expectedmsg.equals(actualmsg))
			System.out.println("Message on click of Ok button match");
		System.out.println();

		Thread.sleep(4000);
	}

	// this method is for validation of text on clicking on Cancel button on
	// Alert
	public void cancelButtonValidation(WebDriver driver) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='row'][2]//following::button[2]"));
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true)", element);
		 */
		Thread.sleep(3000);
		// again clicked on Javascript confirmation button
		element.click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert2.dismiss(); // clicked on cancel on alert button
		String dismiss_msg = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText();
		String expectedmsg2 = "You pressed Cancel!";
		System.out.println("Cancel button actual text: " + dismiss_msg);
		System.out.println("Cancel button expected text: " + expectedmsg2);
		if (expectedmsg2.equals(dismiss_msg))
			System.out.println("Message on click of Cancel button match");

	}
}
