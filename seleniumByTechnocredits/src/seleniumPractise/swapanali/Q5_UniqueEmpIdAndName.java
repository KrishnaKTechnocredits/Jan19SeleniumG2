package seleniumPractise.swapanali;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q5_UniqueEmpIdAndName {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		PrintMaxEmployee(driver);
		driver.close();
	}

	public static void PrintMaxEmployee(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id='demotable']")).click();
		HashMap<String, String>hm1=new HashMap<String, String>();
		int trows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
		for (int i = 1; i <= trows; i++) {
			String empID = driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[(" + i + ")]/td[2]"))
					.getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[(" + i + ")]/td[3]"))
					.getText();
			hm1.put(empID, empName);			
		}		
		System.out.println("Employee details are: "+hm1);
		
        
	}
}
