package sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class Header extends BasePage {


//	MENU

	@FindBy(id="menu-item-12")
	private WebElement buildMenu;
		
	@FindBy(id="menu-item-68")
	private WebElement typesBuildMenu;
		
	@FindBy(id="menu-item-1437")
	private WebElement framelessTypesBuildMenu;
	
	@FindBy(css="#menu-item-40 > a")
	private WebElement bmzTypesBuildMenu;
	
	
	public Header(WebDriver driver) {
		super(driver);
	}

	Actions actions = new Actions(driver);
	
//	Ñhain of menus from the category build - types - frameless
    public void buildMenu() {
    	actions.moveToElement(buildMenu).pause(1000);
    }
	
    public void typesBuildMenu() {
    	actions.moveToElement(typesBuildMenu).pause(1000);
    }
    
    public void framelessTypesBuildMenu() {
    	actions.moveToElement(framelessTypesBuildMenu).pause(1000);
    }
    
    public void clickBmzTypesBuildMenu() {
    	actions.moveToElement(bmzTypesBuildMenu).pause(1000).click().perform();
    }
}
