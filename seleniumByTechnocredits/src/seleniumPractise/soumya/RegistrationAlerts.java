/*
 * Script for alert validation while doing registration
 */
package seleniumPractise.soumya;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

public class RegistrationAlerts {

	// Method for validation of alerts in registration page fields
	public static void BlankFieldAlertValidation() throws InterruptedException, IOException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/index.html");
		System.out.println("URL opened");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='dropdown']//preceding-sibling::li//following-sibling::li//a[@id='registration2']")).click();
		driver.manage().window().maximize();
		System.out.println("Clicked on Registration");
		Thread.sleep(1000);

		// Validation of alert when all fields are blank
		System.out.println("\n" + "Validation 1:");
		System.out.println("Click on submit button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[@type='submit' and @id='btnsubmitsignUp']"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertFullname = "Full name can't be blank";
		if (alert.getText().equals(alertFullname)) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Full Name field validation prompt is not correct");
		}

		// Validation of alert with address field blank
		System.out.println("\n" + "Validation 2:");
		System.out.println("Enter Full Name");
		driver.findElement(By.xpath("//input[@name='fName']")).sendKeys(prop.getProperty("fullname"));
		driver.findElement(By.xpath("//button[@type='submit' and @id='btnsubmitsignUp']"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertAdress = "address cannot be blank";
		if (alert.getText().equals(alertAdress)) {
			System.out.println("Alert: " + alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Address field validation prompt is not correct");
		}

		// Validation of alert with email id field blank
		System.out.println("\n" + "Validation 3:");
		System.out.println("Enter Address");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(prop.getProperty("address"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertEmail = "Please enter email id";
		if (alert.getText().equals(alertEmail)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " EmailId blank field validation prompt is not correct");
		}

		// Validation of alert with wrong format of email id
		System.out.println("\n" + "Validation 4:");
		System.out.println("Enter EmailId");
		WebElement eleEmail = driver.findElement(By.xpath("//input[@id='useremail']"));
		eleEmail.sendKeys(prop.getProperty("emailWrong"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertWrongEmail = "Please use correct email format";
		if (alert.getText().equals(alertWrongEmail)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " EmailId wrong input field validation prompt is not correct");
		}

		// Validation of alert with city field blank
		System.out.println("\n" + "Validation 5:");
		System.out.println("Enter EmailId");
		eleEmail.clear();
		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys(prop.getProperty("email"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertCity = "Please enter City";
		if (alert.getText().equals(alertCity)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " City blank field validation prompt is not correct");
		}

		// Validation of alert with organization field blank
		System.out.println("\n" + "Validation 6:");
		System.out.println("Enter City");
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys(prop.getProperty("city"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertOrganization = "Please enter your current organization";
		if (alert.getText().equals(alertOrganization)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Organization blank field validation prompt is not correct");
		}
		WebElement eleGender = driver.findElement(By.xpath("//input[@id='radio-02']"));
		boolean flag = element.isSelected();
		if (flag == false) {
			eleGender.click();
			System.out.println("Clicked on Element");
			if (eleGender.isSelected() == true) {
				System.out.println("Female radio button selected");
			}
		}

		// Validation of alert with user name field blank
		System.out.println("\n" + "Validation 7:");
		System.out.println("Enter Organization");
		driver.findElement(By.xpath("//input[@id='organization']")).sendKeys(prop.getProperty("company"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertUsername = "Username is mandatory field.";
		if (alert.getText().equals(alertUsername)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Username blank field validation prompt is not correct");
		}

		// Validation of alert with user name less than 5 characters
		System.out.println("\n" + "Validation 8:");
		System.out.println("Enter Username");
		WebElement eleUsername = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		eleUsername.sendKeys(prop.getProperty("usernameWrong"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertUsernameMismatch = "Username length should be greater then 5 characters.";
		if (alert.getText().equals(alertUsernameMismatch)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password blank field validation prompt is not correct");
		}

		// Validation of alert with password field blank
		System.out.println("\n" + "Validation 9:");
		System.out.println("Enter Username");
		eleUsername.clear();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys(prop.getProperty("username"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertPassword = "password is mandatory field.";
		if (alert.getText().equals(alertPassword)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Password blank field validation prompt is not correct");
		}

		// Validation of alert with re-enter password field blank
		System.out.println("\n" + "Validation 10:");
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys(prop.getProperty("password"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertReenterPassword = "please reenter password";
		if (alert.getText().equals(alertReenterPassword)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(alert.getText() + " Reenter Password blank field validation prompt is not correct");
		}

		// Validation of alert with re-enter password with different value
		System.out.println("\n" + "Validation 11:");
		System.out.println("Reenter Password");
		WebElement elePassword = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		elePassword.sendKeys(prop.getProperty("repasswordmismatch"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertReenterPasswordMatch = "retype password donot match.";
		if (alert.getText().equals(alertReenterPasswordMatch)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(
					alert.getText() + " Reenter Password mismatch input field validation prompt is not correct");
		}

		// Validation of alert for not checking terms of service and policy
		// checkbox
		System.out.println("\n" + "Validation 12:");
		System.out.println("Reenter Password");
		elePassword.clear();
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys(prop.getProperty("repassword"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertTerms = "Please agree to terms of service and privacy policy";
		if (alert.getText().equals(alertTerms)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
		} else {
			System.out.println(
					alert.getText() + " Agree to terms of service and policy validation prompt is not correct");
		}

		// Validation of alert by submitting form with complete details
		System.out.println("\n" + "Validation 13:");
		WebElement eleAgreement = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		js.executeScript("arguments[0].scrollIntoView(true)", eleAgreement);
		if (eleAgreement.isSelected() == false) {
			eleAgreement.click();
			System.out.println("Clicked on agreenment");
			if (eleAgreement.isSelected() == true) {
				System.out.println("Terms of service and privacy policy accepted");
			}
		}
		element.click();
		System.out.println("Submit button clicked");
		Thread.sleep(1000);
		driver.switchTo().alert();
		String alertSubmit = "Success";
		if (alert.getText().equals(alertSubmit)) {
			System.out.println(alert.getText() + " ..Alert accepted");
			alert.accept();
			driver.close();
			System.out.println("\n"+"Verification Completed..Window Closed!!!");
		} else {
			System.out.println(alert.getText() + " Submit alert validation prompt is not correct");
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		BlankFieldAlertValidation();
	}
}
