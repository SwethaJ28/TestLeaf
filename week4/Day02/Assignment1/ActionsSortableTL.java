package week4.Day02.Assignment1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSortableTL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		
	    WebElement drag = driver.findElement(By.xpath("//li[text()='Item 1']"));
	    //WebElement drop = driver.findElement(By.xpath("//li[text()='Item 6']"));
	    WebElement drop1 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
	    
	    Actions builder = new Actions(driver);
	    builder.dragAndDropBy(drag, drop1.getLocation().getX(), drop1.getLocation().getY()).perform();	
	    
	    File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snapsA2/Sortable.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);
		}

}
