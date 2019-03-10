/*
 * Script for alert validation in alert demo section
 */
package seleniumPractise.soumya;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;

public class AlertDemo {
	// Method for validation of alerts in alert Demo Section with first name,last name and company name displayed in alert box
	public static void alertVerify() throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/index.html");
		System.out.println("URL opened");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[4]/child::a[@id='basicelements']")).click();
		System.out.println("Basic Elements Clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//header[text()=' Alert Demo ']/parent::section/child::div/div//child::input[@name='ufname']")).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath("//input[contains(@name,'ulname')]")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath("//button[@class='btn btn-primary']//parent::div//preceding-sibling::div[1]/child::input[@name='cmpname']")).sendKeys(prop.getProperty("company"));
		driver.findElement(By.xpath("//input[@name='cmpname']/parent::div//following-sibling::div/child::button[@type='submit']")).click();
		System.out.println("Clicked on Submit Button");
		Alert alert = driver.switchTo().alert();
		String alertText = prop.getProperty("firstname") + " and " + prop.getProperty("lastname") + " and "+ prop.getProperty("company");
		if (alert.getText().equals(alertText)) {
			System.out.println("Alert: " + alert.getText() + "... Alert accepted");
			alert.accept();
			driver.close();
			System.out.println("\n"+"Verification Completed..Window Closed!!!");
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		alertVerify();
	}
}
