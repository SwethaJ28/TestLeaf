package week05.day0102.assignment01;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLeads extends BasicMethods {

	@BeforeTest
	public void setdata() {
		excelfilepath = "./TestData/duplicatelead.xlsx";
	}
	
	@Test(dataProvider = "Dynamic Data", priority=3)
	public void DuplicateLead(String username, String password, String phoneNumber) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Login screen
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Find Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		//Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String Fname=driver.findElement(By.id("createLeadForm_firstName")).getText();
		String Lname=driver.findElement(By.id("createLeadForm_lastName")).getText();
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("Proceedfurther");	
		}
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		WebElement firstName = driver.findElement(By.id("viewLead_firstName_sp"));
		WebElement lastName = driver.findElement(By.id("viewLead_lastName_sp"));
		if (firstName.getText().contains(Fname) && lastName.getText().contains(Lname)) {
			System.out.println("Test case three is passed");	
		}


	}

}
