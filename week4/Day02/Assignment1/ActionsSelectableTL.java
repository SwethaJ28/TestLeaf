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

public class ActionsSelectableTL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item4).click(item5).keyUp(Keys.CONTROL).perform();
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snapsA2/Selectable.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);
		}

}
