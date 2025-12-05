package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class DashboardPage {
    WaitHelper helper;
	WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	private WebElement dashboard;
	
	public boolean viewDashboard()
	{
		helper.waitForElement(driver, dashboard);
		boolean dashboardtxt=dashboard.isDisplayed();
		return dashboardtxt;
	}
}
