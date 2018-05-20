package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlankCommentResponsePage extends BasePage{

	@FindBy(css="#error-page > p:nth-child(2)")
	private WebElement errorMessageBlankComment;

	@FindBy(css="#error-page a")
	private WebElement backLinkBlankComment;
	
	
	public BlankCommentResponsePage(WebDriver driver) {
		super(driver);
	}

    public String actualErrorMessageInBlankCommentResponsePage(){
        return  errorMessageBlankComment.getText();
    }
	
    public void clickBackLinkInBlankCommentResponsePage() {
    	backLinkBlankComment.click();
    }
}
