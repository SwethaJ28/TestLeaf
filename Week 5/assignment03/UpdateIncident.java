package week05.day0102.assignment03;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass {

	@BeforeTest
	public void setData() {
		excelfilepath="./testdatasn/Update incident.xlsx";
	}
	
	@Test(dataProvider = "DynamicData")
	public void updateIncident(String username, String password, String incident, String statesel, String urgencysel, String vIncident) {
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

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incident, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		Select state1 = new Select(driver.findElement(By.id("incident.state")));
		state1.selectByValue(statesel);
		String stateselc = driver.findElement(By.xpath("//*[@id=\"incident.state\"]/option[2]")).getText();
		System.out.println(stateselc);

		Select urgency = new Select(driver.findElement(By.id("incident.urgency")));
		urgency.selectByValue(urgencysel);
		String urgencyselc = driver.findElement(By.xpath("//*[@id=\"incident.urgency\"]/option[1]")).getText();
		System.out.println(urgencyselc);

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		Select dd1 = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		dd1.selectByValue("number");

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(vIncident, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		if (driver.findElement(By.id("incident.state")).getText().contains(stateselc)
				&& driver.findElement(By.id("incident.urgency")).getText().contains(urgencyselc)) {
			System.out.println("Testcase is passed");

		} else {
			System.out.println("Testcase is failed");
		}

	}

}
