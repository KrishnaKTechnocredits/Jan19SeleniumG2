package seleniumPractise.monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

/*5) Registration > Login> password less than/equal to 8 letters > 
alert Validate the alert text
*/
public class RegistrationLoginPwd {

	static WebElement pageScroll(WebDriver driver, String path) {
		WebElement element = driver.findElement(By.xpath(path));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");
		return element;
	}

	static String alertHandling(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		String alertMsg = al.getText();
		al.accept();
		return alertMsg;
	}

	static void pwdValidation(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.id("registration2")).click();
		System.out.println("Registion link is click");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#fullName")).sendKeys("Monali");
		driver.findElement(By.xpath("//input[starts-with(@id,'address')]")).sendKeys("Add123");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Other Email ID')]")).sendKeys("mona@gmail.com");
		driver.findElement(By.cssSelector("#usercity")).sendKeys("Pune");
		driver.findElement(By.cssSelector("input[id*='organization']")).sendKeys("IT Software");
		driver.findElement(By.cssSelector("input[id*='radio-02']")).click();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("Monali");

		// Password Field Validation
		WebElement scroll = pageScroll(driver, "//button[@id='btnsubmitsignUp']");
		scroll.click();
		if (alertHandling(driver).equals("password is mandatory field.")) {
			driver.findElement(By.id("passwordReg")).sendKeys("1234");
			scroll.click();
			if (alertHandling(driver).equals("password length should be greater then 5 characters.")) {
				driver.findElement(By.id("passwordReg")).clear();
				driver.findElement(By.id("passwordReg")).sendKeys("Testing");
				System.out.println("Password Entered");

			} else
				System.out.println("Password Validation Failed");

		}

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		pwdValidation(driver);

	}
}
