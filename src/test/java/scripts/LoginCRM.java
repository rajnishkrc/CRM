package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginCRM {
	WebDriver driver;

	@Test
	public void loginCRM() {
		String baseUrl = "http://crm.techcanvass.co.in/";
		driver.navigate().to(baseUrl);
		driver.findElement(By.id("btnlogin")).click();
		driver.findElement(By.name("txtuname")).sendKeys("techcanvassuser@techcanvass.co.in");
		driver.findElement(By.name("txtpwd")).sendKeys("user1234");
		WebElement role = driver.findElement(By.id("ddlloginuser"));
		Select s = new Select(role);
		s.selectByVisibleText("Student");
		driver.findElement(By.id("loginbtn")).click();
		WebElement label = driver.findElement(By.id("ctl00_lblcompanyname"));
		String actualResult = label.getText();
		Assert.assertEquals(actualResult, "Techcanvass");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();

	}

}
