package testpack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTester {

	WebDriver driver;

	@BeforeEach
	public void setup() {
		driver = new ChromeDriver();
	}

	@Test
	public void eightComponents() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		assertEquals("Web form", title);

		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));

		textBox.sendKeys("Selenium");
		
		WebElement buttonClick=driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
		buttonClick.click();
		
		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);

	}
	
	@Test
	public void DropDownComponent() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		assertEquals("Web form", title);

		WebElement dropDownMenu = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
		Select dropDown = new Select(dropDownMenu);
		dropDown.selectByValue("2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement buttonClick=driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
		buttonClick.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);

	}

	@Test
	public void ImportAFile() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		

		WebElement importFile = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[3]/input"));
		String localFilePath="/Users/anveshjagarlamudi/Downloads/CCF_000143.pdf";
		importFile.sendKeys(localFilePath);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		

	}
	@AfterEach
	public final void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}