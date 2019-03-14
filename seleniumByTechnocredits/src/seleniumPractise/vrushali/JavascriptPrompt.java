//Q4 JavaScript Prompt > Name Entered > Message under the button Validate message with name

package seleniumPractise.vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Init;

public class JavascriptPrompt {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();

		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		System.out.println("Basic element tab clicked");

		JavascriptPrompt.javascriptPropmtOK(driver);
		JavascriptPrompt.javascriptPropmtCancel(driver);

		driver.quit();

	}

	// Method to validate name after accepting Javascript Promp alert.
	public static void javascriptPropmtOK(WebDriver driver) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = driver.findElement(By.cssSelector("button[id='javascriptPromp']"));
		WebElement jspButton = wait.until(ExpectedConditions.visibilityOf(element));
		jspButton.click();
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

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = driver.findElement(By.cssSelector("button[id='javascriptPromp']"));
		WebElement jspButton = wait.until(ExpectedConditions.visibilityOf(element));
		jspButton.click();
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
			System.out.println("Javascript Prompt Cancelled, Test Case passed");
		} else {
			System.out.println(" validation failed");
		}
	}

}
