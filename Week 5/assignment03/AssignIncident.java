package week05.day0102.assignment03;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AssignIncident extends BaseClass{

	@BeforeTest
	public void setData() {
		excelfilepath="./testdatasn/assignincident.xlsx";
	}
	
	@Test(dataProvider = "DynamicData")
	public void assignIncident(String username, String password, String Incident, String group, String Incident1) {

		// switching to frame to enter login information
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		// Again switching back from frame
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		// Finding Incident from the filter
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		// Switching back to frame to create new record
		driver.switchTo().frame(0);

		// For finding existing incident
		Select dd = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		dd.selectByValue("number");

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Incident, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();

		// Handling two Windows
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>();
		windowHandlesList.addAll(windowHandlesSet);

		// switching back to main window
		driver.switchTo().window(windowHandlesList.get(1).toString());
		WebElement findElement = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));

		findElement.sendKeys(group);
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();

		driver.switchTo().window(windowHandlesList.get(0).toString());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		Select dd1 = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		dd1.selectByValue("number");

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Incident1, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		String caller = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		System.out.println(caller);

		if (caller.contains("Software")) {
			System.out.println("Test case is passed");
		} else {
			System.out.println("Test case is failed");
		}

	}

}
