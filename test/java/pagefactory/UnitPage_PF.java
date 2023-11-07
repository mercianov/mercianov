package pagefactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitPage_PF {
	WebDriver driver;
	
	public UnitPage_PF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void chooseFile() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("file-upload")).sendKeys("/Users/mercia/Downloads/data.csv");
		Thread.sleep(3000);
	}


	public void uploadFile() throws InterruptedException {
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(3000);
	}


	public void getMessage() throws InterruptedException {
		assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']")).isDisplayed());
		assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());
		Thread.sleep(3000);
	}

}
