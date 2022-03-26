package week05.day0102.assignment01;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeads extends BasicMethods{

	@BeforeTest
	public void setdata() {
		excelfilepath = "./TestData/createlead.xlsx";
	}
	
	@Test(dataProvider = "Dynamic Data", priority=1)
	public void CreateLed(String username, String password, String companyName, String firstName, String lastName, String source) throws IOException {
		// TODO Auto-generated method stub

		
		// login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//creating the lead
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text() = 'Leads']")).click();
		driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_companyName']")).sendKeys(companyName);
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_lastName']")).sendKeys(lastName);
		Select dd = new Select(driver.findElement(By.id("createLeadForm_dataSourceId")));
		dd.selectByVisibleText(source);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9973757439");
		
		driver.findElement(By.xpath("//input[@class = 'smallSubmit']")).click();
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Test case one is passed");	
		}
		
	}

}
