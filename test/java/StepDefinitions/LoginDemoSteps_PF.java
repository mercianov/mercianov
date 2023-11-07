package StepDefinitions;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.Checkout_PF;
import pagefactory.LoginPage_PF;


public class LoginDemoSteps_PF {
	public WebDriver driver = null;
	LoginPage_PF login;
	
	
	public void prepTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		login = new LoginPage_PF(driver);
	}

	@Given("^user is on website login page$")
	public void user_is_on_login_website() {
		login.isOnLoginWebsite();
	}
	
	@When("^user enter (.*) username and (.*) password$")
	public void user_enter_username_and_password(String type_username, String type_password) throws InterruptedException {
		login = new LoginPage_PF(driver);
		login.enterUsername(type_username);
		login.enterPassword(type_password);
	}

	@And("^click login button$")
	public void click_on_login_button() {
		login.clickLoginButton();
	}
	
	@Then("^user successfully login$")
	public void user_successfully_login() {
		login.successLogin();
	}
	
	@Then("^user get error (.*) on login page$")
	public void get_error_login(String type_error) {
		login.failLogin(type_error);
		
	}

	@Then("user is one website item product list")
	public void user_is_one_website_item_product_list() {
		login.onWebsiteProductList();
	}

	
	public void close() {
		driver.close();
		driver.quit();
	}
	

	
}
