package week4.Day02.Assignment5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_TextChange {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//button[@id='btn']"));

		Boolean until = wait.until(ExpectedConditions.domPropertyToBe(element, "innerText", "Click ME!"));
		//System.out.println(until);
		element.click();
		Thread.sleep(10000);
		
		driver.switchTo().alert().accept();
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snapsA2/eltxchn.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);

	}

}
