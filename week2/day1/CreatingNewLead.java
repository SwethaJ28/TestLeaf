package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingNewLead {
	
	public String splitLeadIDFSC(String leadID) {
		String originalID = null;
		String[] split = leadID.split("\\(");
		for (String str : split) {
			originalID = str;
		}
		return originalID;
		
	}
	
	public String splitleadIDLSC(String findID) {
		String foriginalID = null;
		String[] split = findID.split("\\)");
		for (String str : split) {
			foriginalID = str;
		}
		return foriginalID;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreatingNewLead SE = new CreatingNewLead();
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
		
		//Getting lead ID
		WebElement viewLead = driver.findElement(By.id("viewLead_companyName_sp"));
		System.out.println(viewLead.getText());
		String sampleID = viewLead.getText();
		String findID = SE.splitLeadIDFSC(sampleID);
		System.out.println(findID);
		
		String leadID =SE.splitleadIDLSC(findID);
		System.out.println(leadID);
		
	}

}
