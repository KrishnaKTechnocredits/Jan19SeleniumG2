package seleniumPractise.swapanali;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q3_EmpUnderManagers {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		printEmpUnderManagers(driver);
		driver.close();
	}

	public static void printEmpUnderManagers(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id='demotable']")).click();

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int trows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();

		for (int i = 1; i <= trows; i++) {

			String Manager = driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[(" + i + ")]/td[3]"))
					.getText();
			if (hm.containsKey(Manager)) {
				hm.put(Manager, hm.get(Manager) + 1);
			} else {
				hm.put(Manager, 1);
			}
		}
		Set<String> keys = hm.keySet();
		for (String Managers : keys) {
			System.out.println("Managers name: " + Managers + " and no of employee: " + hm.get(Managers));
		}
	}
}
