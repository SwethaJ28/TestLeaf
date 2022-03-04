package week2.Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launching GoogleChorme
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launching the Application
		driver.get("http://leafground.com/pages/Button.html");
		
		//Handling all the buttons
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.findElement(By.xpath("(//h5[@class='wp-categories-title'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("//button[@id='position']")).getLocation());
		System.out.println(driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color"));
		System.out.println(driver.findElement(By.xpath("//button[@id='size']")).getSize());
		

	}

}
