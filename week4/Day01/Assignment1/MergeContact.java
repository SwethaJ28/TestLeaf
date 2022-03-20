package week4.Day01.Assignment1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>();
		windowHandlesList.addAll(windowHandlesSet);
		
		driver.switchTo().window(windowHandlesList.get(1).toString());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		driver.switchTo().window(windowHandlesList.get(0).toString());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>();
		windowHandlesList1.addAll(windowHandlesSet1);
		
		driver.switchTo().window(windowHandlesList1.get(1).toString());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(windowHandlesList1.get(0).toString());
		
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		
		System.out.println(driver.getTitle());
		File screenShot = driver.getScreenshotAs(OutputType.FILE);

		File image = new File("./snaps/MergeContact.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);

	}

}
