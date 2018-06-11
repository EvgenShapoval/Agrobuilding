package tests;

import org.junit.Assert;
import org.junit.Test;

import pages.BlankCommentResponsePage;
import pages.HomePage;
import sections.CommentForm;

public class BlankCommentTest extends BaseTest{

	private String commentAuthor = "Nick Cave248";
	private String commentEmail = "nickcave248@gmail.com";
	
	
	@Test
	public void blankCommentsTest() {
		driver.get("https://agrobuilding.com/");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickPost931InHomePage();
		
		CommentForm commentForm = new CommentForm(driver);
		
//		Send an empty comment field
		commentForm.inputAuthorCommentForm(commentAuthor);
		commentForm.inputEmailCommentForm(commentEmail);
		commentForm.clickSubmitCommentForm();
	
		BlankCommentResponsePage blankCommentResponsePage = new BlankCommentResponsePage(driver);
		
//		Check the error message
		String expErrorMessage = "ОШИБКА: пожалуйста, введите комментарий.";
		String actErrorMessage = blankCommentResponsePage
				.actualErrorMessageInBlankCommentResponsePage();
		
//		Check the page where link is returning
		blankCommentResponsePage.clickBackLinkInBlankCommentResponsePage();
		String expTitleBackPage = " арочные ангары:";
		String actTitleBackPage = actualTitle();
		System.out.println(actTitleBackPage);
		
		boolean checkErrorMessage = actErrorMessage.equals(expErrorMessage);
		boolean checkTitleBackPage = actTitleBackPage.contains(expTitleBackPage);
				
		Assert.assertTrue("Fail. Expected error message - " + 
				expErrorMessage + ". Actual message - " + actErrorMessage
				 + " Or: Expected a message on the returned page - " +
				 expTitleBackPage + ". Actual message - " + actTitleBackPage, 
				checkErrorMessage & checkTitleBackPage);
		}
}
