package sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class SideBar extends BasePage {

// Search block
	@FindBy(css="#search-2 input")
	private WebElement searchInput;
	
	@FindBy(css="#search-2 button")
	private WebElement searchButton;

// 	News block
	@FindBy(css="#rpwwt-recent-posts-widget-with-thumbnails-2 > ul > li:nth-child(2) > a")
	private WebElement news2Link;
		
	
	public SideBar(WebDriver driver) {
		super(driver);
	}
	
// 	Search block	
    public void inputSearchMessage(String searchMessage) {
    	searchInput.sendKeys(searchMessage);
    }
  
    public void clickSearchButton() {
    	searchButton.click();
    }
    
// 	News block
    public void clickNews2Link() {
    	news2Link.click();
    }
}
