package week05.day0102.assignment01;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DeleteLeads extends BasicMethods {
	@BeforeTest
	public void setdata() {
		excelfilepath = "./TestData/deletelead.xlsx";
	}
	
	@Test(dataProvider = "Dynamic Data", priority=4)
	public void DeleteLead(String username, String password, String phoneNumber) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		// Login screen
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Find Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		WebElement Fsearch = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String inputtt = Fsearch.getText();
		Fsearch.click();
		//Deleting the ID
		driver.findElement(By.linkText("Delete")).click();
		
		//verifying the deleted ID
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(inputtt);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		WebElement FResult = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		System.out.println(FResult.getText());
		if (FResult.getText().contains("No records to display")) {
			System.out.println("Test case four is passed");	
		}
		
	}

}
