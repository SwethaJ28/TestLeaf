package week2.Assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		Select D1=new Select(driver.findElement(By.xpath("//select[@id='dropdown1']")));
		D1.selectByIndex(1);
		
		Select D2=new Select(driver.findElement(By.xpath("//select[@name='dropdown2']")));
		D2.selectByVisibleText("Appium");
		
		Select D3=new Select(driver.findElement(By.xpath("//select[@id='dropdown3']")));
		D3.selectByValue("3");
		
		Select D4=new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
		List<WebElement> options = D4.getOptions();
		System.out.println(options.size());
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("UFT/QTP");
		driver.findElement(By.xpath("(//select)[6]")).sendKeys("Loadrunner");
		
		
	}

}
