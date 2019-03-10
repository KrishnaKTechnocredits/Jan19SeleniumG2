//Program to check validation on Alert Demo - Submit button

package seleniumPractise.purva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Assignment1_1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(400);
		String firstname = "Purva";
		driver.findElement(By.xpath("//input[@id='UserFirstName'][@name='ufname']")).sendKeys(firstname);
		String lastname = "Hanchate";
		driver.findElement(By.xpath("//label[text()='LastName']//following::input")).sendKeys(lastname);
		String cmpyname = "Cognizant";
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cmpyname);

		String expectedText = firstname + " " + "and" + " " + lastname + " " + "and" + " " + cmpyname;
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		String actualText = driver.switchTo().alert().getText();
		System.out.println("Text entered in Alert demo fields: " + expectedText);
		System.out.println("Text displayed on alert popup: " + actualText);
		if (expectedText.equals(actualText)) {
			System.out.println("String displayed on Alert and string entered in text fields match");
		} else
			System.out.println("String displayed on Alert and string entered in text fields dont match");

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}
}
