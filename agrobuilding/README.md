## Testing my own site [Agrobuilding.com](https://agrobuilding.com/)  

With the use  
#### Java+Selenium+JUnit  
#### Page Object - PageFactory  
  
***  
  
### MenuCommentDBSmokeTest  
*Smoke testing of the site menu and comment form, including checking for a new record in the database (MySQL)*  

#### MenuAndNewCommentTest  
Go to the home page
Use Actions (sections.Header) to navigate through the pop-up in the menu:  
* buildMenu  
* typesBuildMenu  
* bmzTypesBuildMenu  
Open the category page "БМЗ"  
  
#### BMZCategory  
Select the second article in this categories  
  
#### sections.CommentForm  
Fill in the fields in the comment form on the opens page  
* TextArea  
* Name  
* Email  
  
#### CommentResponsePage  
Get a response after sending CommentForm  
  
*Compare actual and expected names Author*    
*Check actual and expected the massage commentEmail*    


#### newNameToBDTest
*Check that the database (MySQL) there is a record of a new user and email who wrote a comment*  
  
***
  

### BlankCommentTest
*Negative testing of the comment form*
  
#### HomePage
Click on the article link beskarkasnye-arochnye-angary-proektirovanie-i-stroitelstvo

#### sections.CommentForm
Fill in the fields in the comment form on the opens page   
* TextArea - leave blank  
* Name  
* Email  

#### BlankCommentResponsePage
*Check the error message*  
*Check Title the page where link is returning*  
  
***
  
  
### Page404Test   
*Testing of the various fields on 404 page*  

#### checkTitle404  
Smoke test for the presence Title of 404 pages

#### checkEntryHeader404  
Check header page title  

#### checkNumberLinks404  
Check number links (5 li-elements) in the block "Свежие записи"  

#### checkSearch404  
Check the default message "Search ..."  
Validating the search  

#### checkArchivesDropdown404  
Expected default message archives dropdown - "Выберите месяц"  
Check the title page after select in the archives dropdown  

#### checkCategoriesDropdown404  
Expected default message categories dropdown - "Выберите рубрику"  
Check the title page after select in the categories dropdown  
  
***  
  
  
### SecurityTest  
*Check to try to send HTML code in the search form on the sidebar*  
  
#### HomePage  
Use sections.SideBar, in the search field enter HTML code  
`<form action="http://live.hh.ru"><input type="submit"></form>`  
  
#### ErrorPage  
Receive an error message: The query shows signs of an attempt to exploit the vulnerability on the site  
*Make a screenshot error page*  
*Check the title error page*  
