package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class Page404 extends BasePage {

//	Header page title - Ошибка 404: страница не найдена
	@FindBy(css="#main h1")
	private WebElement entryHeader404;

	
//	Search Field
	@FindBy(css="#main input")
	private WebElement searchField404;
	
	@FindBy(css="#main button")
	private WebElement searchButton404;
		
	
//	Block "Свежие записи" - 5 li-elements
	@FindBys(@FindBy(css="#main ul > li"))
	private List<WebElement> numberLinks404;

	
//	Archives dropdown
	@FindBy(id="archives-dropdown--1")
	private WebElement archivesDropdown404;
	
	@FindBy(css="#archives-dropdown--1 > option:nth-child(1)")
	private WebElement DefaultMessageArchives404;

		
//	Categories dropdown
	@FindBy(id="cat")
	private WebElement categoriesDropdown404;

//	Select default message categories dropdown
	@FindBy(css="#cat > option:nth-child(1)")
	private WebElement defaultMessageCat404;
	
	
	public Page404(WebDriver driver) {
		super(driver);
	}
	
//	Header page title - Ошибка 404: страница не найдена
    public String actualEntryHeader404(){
        return entryHeader404.getText();
    }
	
    
//	Search Field
    public String defaultMessageInSearch404(){
        return searchField404.getAttribute("placeholder");
    }
       
    public void inputSearchField404(String word) {
    	searchField404.sendKeys(word);
    }
 
    public void clickSearchButton404() {
    	searchButton404.click();
    }
	
    
//	Block "Свежие записи" - 5 li-elements
    public int numberLinksRecentEntries404(){
        return numberLinks404.size();
    }
	
    
//	Archives dropdown
    public String actualDefaultMessArch404(){
        return  DefaultMessageArchives404.getText();
    }
    
//	Select default message archives dropdown - Выбирите месяц
    public void selectionArchives404(String linkArchives404) {
    	Select archDropdown = new Select(archivesDropdown404);
    	archDropdown.selectByValue(linkArchives404);
//    	linkArchives404 - "https://agrobuilding.com/2018/02"
    }
    
	
//	Categories dropdown
//	Get default message categories dropdown
    public String actualDefaultMessegeCategories404(){
        return defaultMessageCat404.getText();
    }
    
//	Select category dropdown
    public void selectCategories404(String numberCategories404) {
    	Select categoriesDropdown = new Select(categoriesDropdown404);
    	categoriesDropdown.selectByValue(numberCategories404);
    }	
}
