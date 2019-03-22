package seleniumPractise.swapanali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Q5_LoginWindowMsg {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		loginWindow_msg(driver);
		driver.close();
	}

	public static void loginWindow_msg(WebDriver driver) throws InterruptedException {

		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[contains(@id,'registration2')]")).click();
		Thread.sleep(3000);
		System.out.println("Registration window");
		Thread.sleep(3000);

		String pwd = "Sw@pnali1";
		driver.findElement(By.xpath("//input[starts-with(@id,'unameSignin')]")).sendKeys("Swapnali");
		driver.findElement(By.xpath("//input[starts-with(@id,'pwdSignin')]")).sendKeys(pwd);
		if (pwd.trim().isEmpty()) {
			System.out.println("Please enter password");
		} else if (!pwd.isEmpty() && pwd.length() <= 8) {
			System.out.println("Please enter strong password to continue login!!!");
		} else {
			driver.findElement(By.xpath("//input[starts-with(@id,'pwdSignin')]")).sendKeys(pwd);
			driver.findElement(By.id("btnsubmitdetails")).click();
			Alert alert1 = driver.switchTo().alert();
			System.out.println(alert1.getText());
			alert1.accept();

		}
	}

}
