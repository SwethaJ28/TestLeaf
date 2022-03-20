package week4.Day01.Assignment2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServicenowScript {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Setting up the webdriver to launch chrome
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the application
		driver.get("https://dev56119.service-now.com");
		driver.manage().window().maximize();

		// switching to frame to enter login information
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Servicenow@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		// Again switching back from frame
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		// Finding Incident from the filter
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		// Switching back to frame to create new record
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		// Copying incident number
		WebElement incidentno = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String incidentNo = incidentno.getAttribute("value");
		System.out.println(incidentNo);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();

		// Handling two Windows
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>();
		windowHandlesList.addAll(windowHandlesSet);

		// switching back to main window
		driver.switchTo().window(windowHandlesList.get(1).toString());
		WebElement findElement = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		findElement.sendKeys("admin@email.com");
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("System Administrator")).click();

		driver.switchTo().window(windowHandlesList.get(0).toString());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("New Incident");
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNo, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		// screenshot
		// Taking snap shot
		File screenShot = driver.getScreenshotAs(OutputType.FILE);

		File image = new File("./snaps/incidentNo.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);

	}

}
