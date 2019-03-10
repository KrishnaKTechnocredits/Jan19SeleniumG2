//Program to check validation on clicking Alert button under section "DIFFERENT EXAMPLES OF ALERTS" on "Basic Elements" page

package seleniumPractise.purva;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment1_2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(400);

		WebElement element = driver
				.findElement(By.xpath("//button[@class='btn btn-success' or @id='javascriptAlert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		//clicked on alert button in below line
		element.click();
		System.out.println("Successfully clicked on Alert button");
		String expected = "You must be TechnoCredits student!!";
		Alert alert1 = driver.switchTo().alert();
		String actual = alert1.getText();
		System.out.println("Expected text: " + expected);
		System.out.println("Actual text: " + actual);
		//here in below code we are checking if text on alert and hardcoded text match
		if (expected.equals(actual))
			System.out.println("String match");
		else
			System.out.println("Strings dont match");
		Thread.sleep(3000);
		alert1.accept();
		

	}
}
