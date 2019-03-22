package seleniumPractise.swapanali;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Q2_AlertDisplay {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		alertCompare(driver);
		driver.close();
	}

	public static void alertCompare(WebDriver driver) throws IOException, InterruptedException {

		driver.get("http://automationbykrishna.com/#");
		System.out.println("URL opened");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("asic Ele")).click();
		Thread.sleep(3000);
		System.out.println("Basic element window");
		WebElement element = driver.findElement(By.xpath("//button[text()='Alert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Clicked on alert");
		String msg = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(msg)){
			System.out.println("Alert is accepted");
			alert.accept();
		}
	}

}
