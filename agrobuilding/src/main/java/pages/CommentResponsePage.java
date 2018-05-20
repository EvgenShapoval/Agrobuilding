package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentResponsePage extends BasePage{

	@FindBy(id="author")
	private WebElement commentAuthorResponse;
		
	@FindBy(id="email")
	private WebElement emailResponse;
	
	
	public CommentResponsePage(WebDriver driver) {
		super(driver);
	}

    public String getAuthorCommentResponse() {
    	return commentAuthorResponse.getAttribute("value");
    }
    
    public String getEmailCommentResponse() {
    	return emailResponse.getAttribute("value");
    }
   
}
