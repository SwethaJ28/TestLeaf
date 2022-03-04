package week2.Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launching Google Chrome
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launching the Application
		driver.get("http://leafground.com/pages/Edit.html");
		
		//Handling all the input fields
		driver.findElement(By.id("email")).sendKeys("sample123@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("TestLeaf" + Keys.TAB);
		WebElement EName = driver.findElement(By.xpath("(//input[@name='username'])[1]"));
		System.out.println(EName.getText());
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		System.out.println(enabled);

	}

}
