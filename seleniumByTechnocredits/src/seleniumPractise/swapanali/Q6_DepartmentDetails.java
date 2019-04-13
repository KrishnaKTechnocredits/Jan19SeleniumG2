package seleniumPractise.swapanali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q6_DepartmentDetails {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		printDeptDetails(driver);
		driver.close();
	}

	public static void printDeptDetails(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id='demotable']")).click();
		HashMap<String, ArrayList> hm = new HashMap<String, ArrayList>();

		int trows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
		for (int i = 1; i <= trows; i++) {
			String empID = driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[(" + i + ")]/td[5]"))
					.getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr[(" + i + ")]/td[3]"))
					.getText();
			if (hm.containsKey(empID)) {
				ArrayList<String> list = hm.get(empID);
				list.add(empName);
				hm.put(empID, list);
			} else {
				ArrayList<String> empName1 = new ArrayList<String>();
				empName1.add(empName);
				hm.put(empID, empName1);
			}

		}
		Iterator itr = hm.entrySet().iterator();
		while (itr.hasNext()) {

			System.out.println(itr.next());
			System.out.println("***************************************************");

		}
	}
}
