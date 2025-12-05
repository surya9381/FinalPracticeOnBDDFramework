package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utils.WaitHelper;

public class StepDefinitions extends BaseClass {

	Logger logger;
	@Before
	public void setup() throws IOException
	{
		FileInputStream fis=new FileInputStream("./commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String browser=pro.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		logger=LogManager.getLogger(this.getClass());
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	}
	
	@Given("User launches the browser")
	public void user_launches_the_browser() {
		logger.info("Browser is launching");
	}

	@When("User enters valid url {string}")
	public void user_enters_valid_url(String url) {
		logger.info("Opening the Application");
		driver.get(url);
	}

	@When("User enters an email as {string} and password as {string}")
	public void user_enters_an_email_as_and_password_as(String email, String password) {
	    loginPage=new LoginPage(driver);
	    logger.info("Entering the email");
	    loginPage.setEmail(email);
	    logger.info("Entering the password");
	    loginPage.setPassword(password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		logger.info("Clicking on the login button");
		loginPage.clickOnLogin();
	}

	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		Thread.sleep(3000);
	    dashboard=new DashboardPage(driver);
	    boolean dashboardtxt=dashboard.viewDashboard();
	    Assert.assertTrue(dashboardtxt);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		logger.info("Closing the browser");
		driver.quit();
	}

	
}
