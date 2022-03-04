package week2.Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.navigate().back();
		
		WebElement img = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
		if (img.getAttribute("naturalHeight").equals("0")) {
			System.out.println("The image is broken");
			
		}
		
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();

	}

}
