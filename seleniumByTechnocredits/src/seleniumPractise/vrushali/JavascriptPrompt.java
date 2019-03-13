//Q4 JavaScript Prompt > Name Entered > Message under the button Validate message with name

package seleniumPractise.vrushali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class JavascriptPrompt {

	// Method to validate name after accepting Javascript Promp alert.
	public static void javascriptPropmtOK(WebDriver driver) throws InterruptedException {

		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		System.out.println("Basic element tab clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("button[id='javascriptPromp']")).click();
		System.out.println("Javascript Prompt button clicked");

		String name = "Vrushali";

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		System.out.println("Name entered in alertfiled and alert is accepted");

		String actualOKText = driver.findElement(By.xpath("//p[text()='Hello " + name + "! How are you today?']"))
				.getText();
		System.out.println("Actual Text after acceptng alert: " + actualOKText);

		// Validating actual and expected text
		if (actualOKText.equals("Hello " + name + "! How are you today?")) {
			System.out.println("Javascript Prompt text validated and test case is passed");
		} else {
			System.out.println(" validation failed");
		}

	}

	// Method to validate name after dismiss (Cancel) Javascript Promp alert.
	public static void javascriptPropmtCancel(WebDriver driver) throws InterruptedException {

		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		System.out.println("Basic element tab clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("button[id='javascriptPromp']")).click();
		System.out.println("Javascript Prompt button clicked");

		String name = "Vrushali";

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.dismiss();
		System.out.println("Name entered in alert and alert is dismissed");

		String actualOKText = driver.findElement(By.xpath("//p[text()='User cancelled the prompt.']")).getText();
		System.out.println("Actual Text after acceptng alert: " + actualOKText);
		// Validating actual and expected text
		if (actualOKText.equals("User cancelled the prompt.")) {
			System.out.println("Javascript Prompt Cancelled");
		} else {
			System.out.println(" validation failed");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		JavascriptPrompt.javascriptPropmtOK(driver);
		JavascriptPrompt.javascriptPropmtCancel(driver);

		driver.quit();

	}
}
