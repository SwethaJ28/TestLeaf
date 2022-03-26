package week05.day0102.assignment01;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EditLeads extends BasicMethods {

	@BeforeTest
	public void setdata() {
		excelfilepath = "./TestData/editlead.xlsx";
	}
	
	@Test(dataProvider = "Dynamic Data", priority=2)
	public void EditLead(String username, String password, String newFname,String newCname) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Login screen
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Find Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(newFname);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		//Edit Lead
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCname);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Verification
		WebElement Newcompany = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		if (Newcompany.getText().contains("Amazon")) {
			System.out.println("Test case two is passed");	
		}
		


	}

}
