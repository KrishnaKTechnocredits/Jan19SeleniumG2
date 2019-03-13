package seleniumPractise.swapanali;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;
import util.PropFileOperation;

public class Q1_CompareMsgAlert {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver= Init.initChromeDriver();
		compareMsg(driver);
		driver.close();

	}
	public static void compareMsg(WebDriver driver) throws IOException, InterruptedException{
		Properties prop=PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.partialLinkText("asic Ele")).click();
		Thread.sleep(3000);
		System.out.println("Basic element window");
		//Swapnali and Talekar and Mindtree
		String input=prop.getProperty("FirstName") + " and " + prop.getProperty("LastName") + " and "+ prop.getProperty("Company");
		driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]")).sendKeys("Swapnali");
		driver.findElement(By.xpath("//input[@name='ulname'] | //input[contains(@id,'UserLastName')]")).sendKeys("Talekar");
		driver.findElement(By.xpath("//input[@class='form-control'][@id='UserCompanyName']")).sendKeys("Mindtree");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		String msg=alert.getText();
		alert.accept();
		System.out.println(prop.getProperty("FirstName") + " and " + prop.getProperty("LastName") + " and "+ prop.getProperty("Company"));
		System.out.println("Alert Accepted");
		if(msg.equals(input)){
			System.out.println("Two string are equal");
		}
		else{
			System.out.println("Two string are not equal");
		}
	}

}
