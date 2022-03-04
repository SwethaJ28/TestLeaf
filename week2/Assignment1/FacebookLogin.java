package week2.Assignment1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize Facebook
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Swetha");
		driver.findElement(By.name("lastname")).sendKeys("Jeyachandran");
		driver.findElement(By.name("reg_email__")).sendKeys("9878093445");
		driver.findElement(By.id("password_step_input")).sendKeys("Swetha@28");
		
		Select dd = new Select(driver.findElement(By.id("day")));
		dd.selectByValue("28");
		Select mm = new Select(driver.findElement(By.id("month")));
		mm.selectByIndex(6);
		Select yy = new Select(driver.findElement(By.id("year")));
		yy.selectByVisibleText("1999");
		
		
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		
		
		
	}

}
