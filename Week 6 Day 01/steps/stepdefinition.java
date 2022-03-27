package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefinition {
	public ChromeDriver driver;
	@Given("A Chrome browser is launched")
	public void a_chrome_browser_is_launched() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("Load the Leaftaps url {string}")
	public void load_the_leaftaps_url(String url) {
		driver.get(url); 
	}

	@Given("Maximize the browser")
	public void maximize_the_browser() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Given("Enter the {string} and {string}")
	public void enter_the_and(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password); 
	}

	@When("submit button is clicked")
	public void submit_button_is_clicked() {
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	}

	@Then("user is directed to CRMS\\/SFA Home page")
	public void user_is_directed_to_crms_sfa_home_page() {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
	    
	}

	@Then("click on Leads page")
	public void click_on_leads_page() {
	    
		driver.findElement(By.xpath("//a[text() = 'Leads']")).click();
	}

	@Given("Create lead link is clicked")
	public void create_lead_link_is_clicked() {
	    
		driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();
	}

	@Given("Enter the {string} {string} {string}")
	public void enter_the_(String cname, String fname, String lname) {
	    
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_companyName']")).sendKeys(cname);
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id = 'createLeadForm_lastName']")).sendKeys(lname);
	}

	@When("createLead button is clicked")
	public void create_lead_button_is_clicked() {
	    
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9973757439");
		driver.findElement(By.xpath("//input[@class = 'smallSubmit']")).click();
	}

	@Then("view Lead screen should be displayed")
	public void view_lead_screen_should_be_displayed() {
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Test case one is passed");
		}
		driver.close();
	}

	@Given("Find lead link is clicked")
	public void find_lead_link_is_clicked() {
		driver.findElement(By.linkText("Find Leads")).click();
	    
	}

	@Given("enter the {string}")
	public void enter_the_(String newFname) throws InterruptedException {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(newFname);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
	    
	}

	@Given("click on first resulting link for edit lead")
	public void click_on_first_resulting_link_for_edit_lead() {
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
	    
	}

	@Given("click Edit option")
	public void click_edit_option() {
		driver.findElement(By.linkText("Edit")).click();
	    
	}

	@Given("Change the {string} and click on update")
	public void change_the_and_click_on_update(String newCname) {
	    
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCname);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
	}


	@Given("Navigate to phonenumber page and enter the {string}")
	public void navigate_to_phonenumber_page_and_enter_the(String pnum) {
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);

	}

	@Given("click on first resulting link of duplicate lead")
	public void click_on_first_resulting_link_of_duplicate_lead() {
	    
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
	}

	@Given("click Duplicate option")
	public void click_duplicate_option() {
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
			System.out.println("Test case three is passed");
		}
	    
	}

	@Given("click on first resulting link of delete lead")
	public void click_on_first_resulting_link_of_delete_lead() throws InterruptedException {
		WebElement Fsearch = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String inputtt = Fsearch.getText();
		Fsearch.click();
		
		//Deleting the ID
		driver.findElement(By.linkText("Delete")).click();
		
		//verifying the deleted ID
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(inputtt);
	}

	@Given("click Delete option")
	public void click_delete_option() throws InterruptedException {

		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		WebElement FResult = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		System.out.println(FResult.getText());
		if (FResult.getText().contains("No records to display")) {
			System.out.println("Test case four is passed");	
		}
		
	    
	}

	@Given("Merge lead link is clicked")
	public void merge_lead_link_is_clicked() {
	    
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
	}

	@Given("click on first resulting link of from option")
	public void click_on_first_resulting_link_of_from_option() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>();
		windowHandlesList.addAll(windowHandlesSet);
		
		driver.switchTo().window(windowHandlesList.get(1).toString());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		driver.switchTo().window(windowHandlesList.get(0).toString());
	    
	}

	@Given("click on first resulting link of to option")
	public void click_on_first_resulting_link_of_to_option() {
	    
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>();
		windowHandlesList1.addAll(windowHandlesSet1);
		
		driver.switchTo().window(windowHandlesList1.get(1).toString());
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(windowHandlesList1.get(0).toString());
	}

	@Given("click merge option")
	public void click_merge_option() {
	    
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
	}

}
