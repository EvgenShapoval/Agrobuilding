package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.Page404;

public class Page404Test extends BaseTest {

	private Page404 page404 = new Page404(driver);
	
	@Before
	public void beforeTest() {
//		Sending request to a nonexistent page
		driver.get("https://agrobuilding.com/dadh");
	}

	@Test
	public void CheckTitle404() {

//		Smoke test for the presence of 404 pages
		String expectedTitle = "�������� �� ������� - ����C����";
		String actualTitle = actualTitle();
				
		Assert.assertTrue("Fail. Expected title 404 page - " + expectedTitle + 
				". Actual message - " + actualTitle, 
				expectedTitle.equals(actualTitle));
	}
	
	@Test
	public void checkElements404() {
	
//		Check entry header page title
		String expEntryHeader = "������ 404: �������� �� �������";
		String actEntryHeader = page404.actualEntryHeader404();
		
//		Check number links (5 li-elements) in the block "������ ������"
		int expNumberLinks = 5;
		int actNumberLinks = page404.numberLinksRecentEntries404();
	
		boolean checkEntryHeader = expEntryHeader.equals(actEntryHeader);
		boolean checkNumberLinks = expNumberLinks == actNumberLinks;
		
		Assert.assertTrue("Fail. Expected entry header message - " + 
		expEntryHeader + ". Actual message - " + actEntryHeader + 
		" Or: Expected the number links in the block ������ ������ - " +
		expNumberLinks + ". Actual the number links - " + actNumberLinks, 
		checkEntryHeader & checkNumberLinks);
	}
	
	@Test
	public void checkSearch404() {
	
//		Check the default message "Search �" in search-field
		String expMesSearch = "Search �";
		String actMesSearch = page404.defaultMessageInSearch404();
		
//		Validating the search
		page404.inputSearchField404("������������");
		page404.clickSearchButton404();
		
		String expTitlePageSearch = " ������ ������������ ";
		String actTitlePageSearch = actualTitle();
		
		boolean checkMessSearchField = actMesSearch.equals(expMesSearch);
		boolean validatingSearch = actTitlePageSearch.contains(expTitlePageSearch);
		
		Assert.assertTrue("Fail. Expected message in search-field - " + 
				expMesSearch + ". Actual message - " + actMesSearch + 
				" Or: Expected the number links in the widget title - " +
				expTitlePageSearch + ". Actual the number links - " + actTitlePageSearch, 
				checkMessSearchField & validatingSearch);
	}
	
	@Test
	public void checkArchivesDropdown404() {
		
//		Expected default message archives dropdown - �������� �����
		String expDefaultMessArch = "�������� �����";
		String actDefaultMessArch = page404.actualDefaultMessArch404();
		
//		Check the title page after select in the archives dropdown
		page404.selectionArchives404("https://agrobuilding.com/2018/02");
				
		String expTitlePageArch = "������� 2018 - ����C����";
		String actTitlePageArch = actualTitle();
		
		boolean checkDefaultMessArch = expDefaultMessArch.equals(actDefaultMessArch);
		boolean checkTitlePageArch = expTitlePageArch.equals(actTitlePageArch);
		
		Assert.assertTrue("Fail. Expected default message in archives dropdown - " + 
		expDefaultMessArch + ". Actual message - " + actDefaultMessArch + 
		" Or: Expected the title page after select in the archives dropdown - " +
				expTitlePageArch + ". Actual the title - " + actTitlePageArch, 
				checkDefaultMessArch & checkTitlePageArch);
	}
	
	@Test
	public void checkCategoriesDropdown404() {
		
//		Expected default message categories dropdown - �������� �������
		String expdefaultMessCat = "�������� �������";
		String actdefaultMessCat = page404.actualDefaultMessegeCategories404();
		
//		Check the title page after select in the categories dropdown
		page404.selectCategories404("94");
				
		String expTitlePageCat = "������ Comsilium - ����C����";
		String actTitlePageCat = actualTitle();
				
		boolean checkdefaultMessCat = expdefaultMessCat.equals(actdefaultMessCat);
		boolean checkTitlePageCat = expTitlePageCat.equals(actTitlePageCat);
		
		Assert.assertTrue("Fail. Expected the default message in the categories dropdown - " + 
				expdefaultMessCat + ". Actual message - " + actdefaultMessCat + 
		" Or: Expected the title page after select in the categories dropdown - " +
		expTitlePageCat + ". Actual the title - " + actTitlePageCat, 
		checkdefaultMessCat & checkTitlePageCat);
	}
}