package week2.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Launching Chrome
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching Application
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// Login screen
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Find Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("044");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8939227788");
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
			System.out.println("Testcase is passed");
			driver.close();	
		}
		else
		{
			System.out.println("Testcase is failed");
		}

	}

}
