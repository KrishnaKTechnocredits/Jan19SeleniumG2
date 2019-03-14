// Q1 Alert Demo > Submit > Alert > Validation

package seleniumPractise.vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Init;

public class AlertSubmitValidation {

	public static void alertSubmitButtonValidation(WebDriver driver) throws InterruptedException {
		String fname = "Vrushali";
		String lname = "Poke";
		String companyName = "TCS";

		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element1 = driver.findElement(By.xpath("//input[contains(@name, 'ufn')]"));

		WebElement javaSriptAlert = wait.until(ExpectedConditions.visibilityOf(element1));
		javaSriptAlert.sendKeys(fname);
		
		driver.findElement(By.xpath("//input[@name= 'ulname']| //input[@id= 'UserLastName']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id= 'UserCompanyName' and @name = 'cmpname']")).sendKeys(companyName);
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();

		String expectedString = fname + " and " + lname + " and " + companyName;
		System.out.println("expectedString " + expectedString);
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		String actualText = alert.getText();
		System.out.println("actualText: " + actualText);

		// code to validate alert submit text
		if (actualText.equals(expectedString)) {

			System.out.println("Text on alert matched with expected string. Test case Passed ");
		} else {
			System.out.println("Failed to match text on alert with expected string");
		}
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id= 'basicelements']")).click();
		
		AlertSubmitValidation.alertSubmitButtonValidation(driver);
		driver.quit();

	}
}