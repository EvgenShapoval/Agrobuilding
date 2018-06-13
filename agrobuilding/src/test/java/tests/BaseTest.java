package tests;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

	protected static WebDriver driver;
		
	@BeforeClass
	public static void beforeClassTest() {
//		System.setProperty("webdriver.chrome.driver", "D:/soft/java/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }
	
	@AfterClass
    public static void afterTest() {
		driver.quit();
	}
	
	public String actualTitle() {
		String title = driver.getTitle();
		return title;
	}
}
