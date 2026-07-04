package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {
	
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println( driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement textBox = driver.findElement(By.name("my-text"));
        
        textBox.sendKeys("Cool");
        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("pwd");
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.sendKeys("text area hjok");
        
        
      
        	
        
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();
       
        driver.quit();
    }

}
