package week2.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
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
		
		//Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("FREWOR");
		driver.findElement(By.id("lastNameField")).sendKeys("UIOGTY");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("FREWOR");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("UIOGTY");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Accounting");
		driver.findElement(By.id("createContactForm_description")).sendKeys("New Contact");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("frewor.uiogty@gmail.com");
		Select dd=new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		dd.selectByVisibleText("Hawaii");
		driver.findElement(By.className("smallSubmit")).click();
		
		//Edit Contact
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Update Contact");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());
		
		

	}

}
