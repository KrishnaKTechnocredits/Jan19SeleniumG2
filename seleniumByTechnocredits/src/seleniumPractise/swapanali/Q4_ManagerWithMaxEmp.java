package seleniumPractise.swapanali;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q4_ManagerWithMaxEmp {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		PrintMaxEmployee(driver);
		driver.close();
	}

	public static void PrintMaxEmployee(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id='demotable']")).click();

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int trows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();

		for (int i = 1; i <= trows; i++) {

			String Manager = driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[(" + i + ")]/td[4]"))
					.getText();
			if (hm.containsKey(Manager)) {
				hm.put(Manager, hm.get(Manager) + 1);
			} else {
				hm.put(Manager, 1);
			}
		}
		Set<String> keys = hm.keySet();
		int max=0;
		String maxEmpManagers="";
		for (String Managers : keys) {
			if(max<hm.get(Managers)){
				max=hm.get(Managers);
				maxEmpManagers=Managers;
			}
		}
		System.out.println("Manager name is: "+maxEmpManagers+" and no of employee is: "+max);
	}
}
