package week4.Day02.Assignment1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDropTL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snapsA2/DropTL.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);
	}

}
