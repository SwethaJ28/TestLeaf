package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindLeadXpath {
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

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FindLeadXpath FL = new FindLeadXpath();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		// login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//creating the lead
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text() = 'Leads']")).click();
		driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_companyName']")).sendKeys("Byjus");
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_firstName']")).sendKeys("Swetha");
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_lastName']")).sendKeys("Jeyachandran");
		
		driver.findElement(By.xpath("//input[@class = 'smallSubmit']")).click();
		
		//Find lead
		
		WebElement viewLead = driver.findElement(By.id("viewLead_companyName_sp"));
		System.out.println(viewLead.getText());
		String sampleID = viewLead.getText();
		String findID = FL.splitLeadIDFSC(sampleID);
		System.out.println(findID);
		String leadID =FL.splitleadIDLSC(findID);
		System.out.println(leadID);
		
		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();
		driver.findElement(By.name("id")).sendKeys(leadID);
		driver.findElement(By.xpath("((//label[@class = 'x-form-item-label'])[3]/following::input)[29]")).sendKeys("Swetha");
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Edit Lead
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id = 'updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id = 'updateLeadForm_companyName']")).sendKeys("Vendatu");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		//Extracting the name
		
		WebElement companyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String name = null;
		String ucompanyName =companyName.getText();
		String[] Fcompanyname = ucompanyName.split(" ");
		for (String str : Fcompanyname) {
			name = str;
			break;
		}
		
		//verification
		
		if (name.equals("Vendatu")) {
			System.out.println("Testcase is passed");
		}
		else {
			System.out.println("Testcase is failed");
		}
		
}

}
