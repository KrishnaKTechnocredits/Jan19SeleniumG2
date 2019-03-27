package seleniumPractise.swapanali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q1_TotalManagers {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= Init.initChromeDriver();
		printTotalManagersCount(driver);
		driver.close();
		
	}
	public static void printTotalManagersCount(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id='demotable']")).click();		
		
		int trows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
		int count=0;
		for(int i=1;i<=trows;i++){
			count++;
		}
		System.out.println("Total managers are: "+count);
	}
}