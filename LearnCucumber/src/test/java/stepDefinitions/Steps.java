package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
//import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user")+"//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	    
	}

	@When("User open URL {string}")
	public void user_open_url(String Url) {
		driver.get(Url);
	   
	}

	@When("User Enter Email As {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setUserPassword(password);
	    
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.Login();
	   
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
			
		}
	    
	}

	@When("User Click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.Logout();
		Thread.sleep(3000);
	   
	}

	@Then("close Browser")
	public void close_browser() {
		driver.quit();
	    
	}
}
