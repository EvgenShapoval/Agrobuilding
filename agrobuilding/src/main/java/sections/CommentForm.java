package sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class CommentForm extends BasePage{

	@FindBy(id="comment")
	private WebElement textArea;
		
	@FindBy(id="author")
	private WebElement author;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="submit")
	private WebElement commentSubmit;
	
		
	public CommentForm(WebDriver driver) {
		super(driver);
	}

    public void inputTextAreaCommentForm(String text) {
    	textArea.clear();
    	textArea.sendKeys(text);
    }
    
    public void inputAuthorCommentForm(String name) {
    	author.clear();
    	author.sendKeys(name);
    }
    
    public void inputEmailCommentForm(String mail) {
    	email.clear();
    	email.sendKeys(mail);
    }
	
    public void clickSubmitCommentForm() {
    	commentSubmit.click();
    }
}
