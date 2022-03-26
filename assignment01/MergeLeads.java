package week05.day0102.assignment01;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeLeads extends BasicMethods {

	@Test(priority=5)
	public void MergeLead() throws IOException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>();
		windowHandlesList.addAll(windowHandlesSet);
		
		driver.switchTo().window(windowHandlesList.get(1).toString());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		driver.switchTo().window(windowHandlesList.get(0).toString());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>();
		windowHandlesList1.addAll(windowHandlesSet1);
		
		driver.switchTo().window(windowHandlesList1.get(1).toString());
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(windowHandlesList1.get(0).toString());
		
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Test case five is passed");	
		}

	}

}
