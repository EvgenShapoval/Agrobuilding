package category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class FramelessCategory extends BasePage{

	@FindBy(css="#post-913 > a")
	private WebElement vseOBeskarkasnyhArochnyhAngarahLink;
	
	
	public FramelessCategory(WebDriver driver) {
		super(driver);
	}
	
    public void clickOnLinkFramelessCategory() {
    	vseOBeskarkasnyhArochnyhAngarahLink.click();
    }
}
