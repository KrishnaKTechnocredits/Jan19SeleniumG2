package seleniumPractise.swapanali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Q3_Javascript_Confirmation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= Init.initChromeDriver();
		Confirmation_msg(driver);
		driver.close();

	}
	public static void Confirmation_msg(WebDriver driver) throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.partialLinkText("asic Ele")).click();
		Thread.sleep(3000);
		System.out.println("Basic element window");
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//button[starts-with(@id,'javascriptC')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		String msg = driver.findElement(By.xpath("//p[@class='help-block' and @id='pgraphdemo']")).getText();
		if (msg.equals("You pressed OK!")) {
			System.out.println("User clicked on Ok button");

		} else if (msg.equals("You pressed Cancel!")) {
			System.out.println("User clicked on Cancel button");
			alert1.dismiss();
		}
		Thread.sleep(10000);	
	}

}
