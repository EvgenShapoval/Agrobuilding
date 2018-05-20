package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import sections.SideBar;

public class SecurityTest extends BaseTest{

	@Test
	public void checkSecurity() throws IOException {
		driver.get("https://agrobuilding.com/");
	
		SideBar sideBar = new SideBar(driver);
		
//		In the search field enter HTML code
		String inputHTML = "<form action=\"http://live.hh.ru\"><input type=\"submit\"></form>";
		
		sideBar.inputSearchMessage(inputHTML);
		sideBar.clickSearchButton();
	
		String expTitle = "This request rejected!";
		String actTitle = actualTitle();
	
//		Screenshot error page
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("c:\\screenshot.png"));
	
//		Check the title page
		Assert.assertTrue("Fail. Expected message in title - " + 
			expTitle + ". Actual message - " + actTitle, 
			actTitle.equals(expTitle));
		}
}
