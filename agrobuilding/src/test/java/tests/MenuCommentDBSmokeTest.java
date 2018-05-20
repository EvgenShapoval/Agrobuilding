package tests;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import category.BMZCategory;
import data.DataBase;
import pages.CommentResponsePage;
import sections.CommentForm;
import sections.Header;

public class MenuCommentDBSmokeTest extends BaseTest{

	private String commentAuthor = "Nick Cave258";
	private String commentEmail = "nickcave258@gmail.com";
//	Change in 79 row - comment_author='Nick Cave258'

	private String MySQLDriver = "com.mysql.jdbc.Driver";
	private String dataBaseURL = "jdbc:mysql://db1.cityhost.com.ua/agrobuild";
	private static final Logger log = LogManager.getLogger(MenuCommentDBSmokeTest.class);
	private DataBase dBMySQL;
	
	@Test
	public void MenuAndNewCommentTest() {
		driver.get("https://agrobuilding.com/");
		
		Header menuOnHomePage = new Header(driver);
		
		menuOnHomePage.buildMenu();
		menuOnHomePage.typesBuildMenu();
		menuOnHomePage.clickBmzTypesBuildMenu();
		
		BMZCategory bmzCategory = new BMZCategory(driver);
		bmzCategory.clickOnLinkBmzCategory();
		
		CommentForm commentForm = new CommentForm(driver);
		
//		Go to the page ukrainskijRynokNews. Fill in the fields of the comment form
		commentForm.inputTextAreaCommentForm("Message in TextArea on Comment Form");
		commentForm.inputAuthorCommentForm(commentAuthor);
		commentForm.inputEmailCommentForm(commentEmail);
		commentForm.clickSubmitCommentForm();
		
		CommentResponsePage commentResponse = new CommentResponsePage(driver);
		
//		Get a response after sending CommentForm
		String authorcommentResponse = commentResponse.getAuthorCommentResponse();
		String emailcommentResponse = commentResponse.getEmailCommentResponse();
		
//		Compare the names Author
		boolean compareAuthor = authorcommentResponse.equals(commentAuthor);
		
//		Check the massage commentEmail
		boolean compareEmail = emailcommentResponse.equals(commentEmail);
		
//		Check the massages in response to sent CommentForm
		Assert.assertTrue("Fail. Expected names Author - " + commentAuthor + 
				". Actual names - " + authorcommentResponse + 
				" Or: Expected email - " + commentEmail +
				". Actual email - " + emailcommentResponse, 
				compareAuthor & compareEmail);
		}
	
	@Test
	public void newNameToBDTest() throws SQLException, ClassNotFoundException, IOException {
				
		log.info("--- Test STARTED --------");
		log.info("--- Connect MySQL DB --------");
		dBMySQL = new DataBase(dataBaseURL, MySQLDriver);
		log.info("--- Connected to MySQL --------");
		
		String testMySQLValue = dBMySQL
				.selectValue("select comment_author_email from wp_comments"
				+ " where comment_author='Nick Cave258'");
		log.info("Result value is " + testMySQLValue);
		
//		Check for a new entry in the database
		Assert.assertTrue("testMySQLValue Not equals commentName", 
				testMySQLValue.equals(commentEmail));
		}
}
