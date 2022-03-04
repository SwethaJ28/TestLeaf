package week2.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launching Chrome
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launching Application
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Login screen
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Find Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("Duplicate@leaf.com");
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
			System.out.println("Testcase is passed");
		}
		else {
			System.out.println("Testcase is failed");
		}
		driver.close();
		
		
		
		
		

	}

}
