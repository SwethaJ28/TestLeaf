package week2.Assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.findElement(By.xpath("(//a[text() = 'Go to Home Page'])[1]")).click();
		driver.findElement(By.xpath("(//h5[@class='wp-categories-title'])[3]")).click();
		String attribute = driver.findElement(By.xpath("//a[text() = 'Find where am supposed to go without clicking me?']")).getAttribute("href");
		System.out.println(attribute);
		//WebElement findElement = driver.findElement(By.xpath("//a[text() = 'Verify am I broken?']"));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		
	}

}
