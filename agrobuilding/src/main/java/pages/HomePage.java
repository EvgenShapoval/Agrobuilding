package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends BasePage {

//	class="widget-header" - 10 elements
	@FindBys(@FindBy(css=".widget-header"))
	private List<WebElement> categoryWidgetOnHomePage;
	
	@FindBy(css="#post-931 > div > h1 > a")
	private WebElement post931;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

    public int numberCategoryWidgetOnHomePage(){
        return categoryWidgetOnHomePage.size();
    }
    
    public void clickPost931InHomePage() {
    	post931.click();
    }
}