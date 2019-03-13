package seleniumPractise.swapanali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Q4_JavaScript_Prompt {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= Init.initChromeDriver();
		javaScriptPromt_Msg(driver);
		driver.close();
	}
	public static void javaScriptPromt_Msg(WebDriver driver) throws InterruptedException{
		
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.partialLinkText("asic Ele")).click();
		Thread.sleep(3000);
		System.out.println("Basic element window");
		Thread.sleep(3000);
		
		WebElement element=driver.findElement(By.xpath("//button[starts-with(@id,'javascriptC')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert alert=driver.switchTo().alert();
		String input="Swapnali";
		alert.sendKeys(input);
		alert.accept();
		String msg="Hello ".concat(input).concat(" How are you today?");
		System.out.println(msg);
	}
}
