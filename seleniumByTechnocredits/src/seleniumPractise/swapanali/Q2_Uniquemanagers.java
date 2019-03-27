package seleniumPractise.swapanali;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q2_Uniquemanagers {
	
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver= Init.initChromeDriver();
			printUniqueManagersCount(driver);
			driver.close();
		}		
		public static void printUniqueManagersCount(WebDriver driver){
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);			
			driver.get("http://automationbykrishna.com/#");
			driver.findElement(By.cssSelector("a[id='demotable']")).click();		
			
			HashMap<String, Integer> hm=new HashMap<String, Integer>();
			int trows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();

			for(int i=1;i<=trows;i++){
				
				String Manager=driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[("+i+")]/td[3]")).getText();
				if(hm.containsKey(Manager)){
					hm.put(Manager, hm.get(Manager)+1);
						}
				else{
					hm.put(Manager, 1);
					}
			}
			Set<String> keys=hm.keySet();			
			System.out.println("Total Unique Managers are: "+keys.size());
		}
}
