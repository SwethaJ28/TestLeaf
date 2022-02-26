package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditRecords {
	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//maximize the window
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Login into Application
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Creating new lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ZOHO");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("BOONEO");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("FEDRICK");
		Select dd = new Select(driver.findElement(By.id("createLeadForm_dataSourceId")));
		dd.selectByIndex(4);
		driver.findElement(By.className("smallSubmit")).click();
		
		// Editing the Lead information
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TEXAS");
		driver.findElement(By.className("smallSubmit")).click();
	}

}
