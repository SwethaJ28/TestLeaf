package week2.Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionalExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.findElement(By.id("input-username")).sendKeys("FRANSCIS7833456");
		driver.findElement(By.id("input-firstname")).sendKeys("FRANSCIS");
		driver.findElement(By.id("input-lastname")).sendKeys("BONEO");
		driver.findElement(By.id("input-email")).sendKeys("franscisjak12@gmail.com");
		
		Select dd=new Select(driver.findElement(By.id("input-country")));
		dd.selectByVisibleText("India");
		driver.findElement(By.id("input-password")).sendKeys("DemoAccount");
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		System.out.println(driver.getTitle());
		

	}

}
