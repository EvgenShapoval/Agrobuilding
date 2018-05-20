package category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class BMZCategory extends BasePage{

	@FindBy(css="#post-295 > div > a")
	private WebElement ukrainskijRynokNewsLink;
	
	
	public BMZCategory(WebDriver driver) {
		super(driver);
	}
	
    public void clickOnLinkBmzCategory() {
    	ukrainskijRynokNewsLink.click();
    }
}
