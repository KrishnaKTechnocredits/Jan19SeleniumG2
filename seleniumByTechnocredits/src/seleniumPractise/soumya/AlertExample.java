/*
 * Script for alert validation from different examples of alerts section
 */
package seleniumPractise.soumya;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

public class AlertExample {
	// Method for validation of alerts from different examples of alerts section by clicking on alert button
	public static void alertVerify() throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		System.out.println("URL opened");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[4]/child::a[@id='basicelements']")).click();
		System.out.println("Basic Elements Clicked");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[text()='Alert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Alert Clicked");
		String alertText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(alertText)) {
			System.out.println("Alert: " + alert.getText() + "... Alert accepted");
			alert.accept();
			driver.close();
			System.out.println("\n" + "Verification Completed..Window Closed!!!");
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		alertVerify();
	}
}
