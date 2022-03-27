package week05.day0102.assignment03;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public ChromeDriver driver;
	public String excelfilepath;
	int i=1;

	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://dev56119.service-now.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterMethod
	public void afterMethod() throws IOException {
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./FrameWork/img00"+i+".jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);
		i=i+1;
		driver.close();
	}
	
	@DataProvider(name="DynamicData")
	public String[][] dataproviderCL() throws IOException{
		String[][] data = ReadExcel1.data(excelfilepath);
		return data;
		
	}

}
