package se.iths.selenium_first_project;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	protected WebDriver driver;
	

	@Before
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mohamed\\Documents\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
	}
	
	@After
	public void teardown(){
		driver.quit();
	}
	public void search(String search){
	 
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys(search);

        element.submit();
	}
	
	public void verifyResult(String result){
		final String temp = result.toLowerCase();
		
		System.out.println("Page title is: " + driver.getTitle());
	        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getTitle().toLowerCase().startsWith(temp);
	            }
	        });
	        assertEquals(result + " - Sök på Google",  driver.getTitle());
	}

}
