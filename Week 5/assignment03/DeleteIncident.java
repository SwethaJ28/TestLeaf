package week05.day0102.assignment03;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass{

	@BeforeTest
	public void setData() {
		excelfilepath="./testdatasn/Delete incident.xlsx";
	}
	
	@Test(dataProvider = "DynamicData")
	public void assignIncident(String username, String password, String incidentNO) throws InterruptedException {


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

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNO, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		System.out.println("Execution is completed");
		Thread.sleep(30);
		String text = driver.findElement(By.xpath("//tr[@class='list2_no_records']/td")).getAttribute("innerHTML");
		System.out.println(text);

	}

}
