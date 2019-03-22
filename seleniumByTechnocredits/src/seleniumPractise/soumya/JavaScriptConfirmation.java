/*
* Script for JavaScript Confirmation alert validation from different examples of alerts section
*/
package seleniumPractise.soumya;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

public class JavaScriptConfirmation {
	// Method for validation of JavaScript Confirmation alert from different examples of alerts section by clicking on JavaScript Confirmation button
	public static void javaScriptConfirmationAlert() throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		System.out.println("URL opened");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[4]/child::a[@id='basicelements']")).click();
		System.out.println("Basic Elements Clicked");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[text()='Javascript Confirmation']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Javascript Confirmation Clicked");
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Alert: " + alert.getText());
			alert.accept();
			if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed OK!")) {
				System.out.println(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText());
				System.out.println("Alert is successfully accepted and message is correct");
			}
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			element.click();
			System.out.println("Javascript Confirmation Clicked");
			alert = driver.switchTo().alert();
			Thread.sleep(1000);
			if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
				System.out.println("Alert: " + alert.getText());
				alert.dismiss();
				if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed Cancel!")) {
					System.out.println(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText());
					System.out.println("Alert is successfully cancelled and message is correct");
				}
			}
		}
		driver.close();
		System.out.println("\n" + "Verification Completed..Window Closed!!!");
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		javaScriptConfirmationAlert();
	}
}
