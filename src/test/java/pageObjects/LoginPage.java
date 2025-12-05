package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class LoginPage {

	WaitHelper helper;
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		helper=new WaitHelper();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement txtemail;
	
	@FindBy(id = "Password")
	private WebElement txtpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	public void setEmail(String email)
	{
		
		helper.waitForElement(driver, txtemail);
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		helper.waitForElement(driver, txtpassword);
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		helper.waitForElement(driver, loginBtn);
		loginBtn.click();
	}
	
	
}
