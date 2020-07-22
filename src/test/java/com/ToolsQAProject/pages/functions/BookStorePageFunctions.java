package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.BookStorePageElements;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.relevantcodes.extentreports.ExtentTest;

public class BookStorePageFunctions {
	
	public static void bookstorelogin() throws IOException
	{
		CommonDef.implicitWait();
		CommonDef.clickJS(BookStorePageElements.bookstore_login_button());
		//CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Login"));
		CommonDef.sendKeys(BookStorePageElements.bookstore_username_Box(), "hari");
		CommonDef.sendKeys(BookStorePageElements.bookstore_password_Box(), "hari@123");
		CommonDef.clickJS(BookStorePageElements.bookstore_login_button());
		
	}
	
	public static void addingbooks() throws IOException
	{
		CommonDef.clickJS(BookStorePageElements.select_book_link_dynamic("Git Pocket Guide"));
		CommonDef.assertTextEquals( BookStorePageElements.validate_book_name_dynamic("Git Pocket Guide"), "Git Pocket Guide");
		CommonDef.clickJS(BookStorePageElements.bookstore_addNewRecordButton_button());
		CommonDef.waitnow();
		CommonDef.assertTextEquals( CommonDef.getAlertText(), "Book added to your collection.");
		CommonDef.alertDismiss();
		CommonDef.clickJS(BookStorePageElements.bookstore_backtostoreButton_button());
		CommonDef.clickJS(BookStorePageElements.select_book_link_dynamic("Learning JavaScript Design Patterns"));
		CommonDef.assertTextEquals( BookStorePageElements.validate_book_name_dynamic("Learning JavaScript Design Patterns"), "Learning JavaScript Design Patterns");
		CommonDef.clickJS(BookStorePageElements.bookstore_addNewRecordButton_button());
		CommonDef.waitnow();
		CommonDef.assertTextEquals( CommonDef.getAlertText(), "Book added to your collection.");
		CommonDef.alertDismiss();
		CommonDef.clickJS(BookStorePageElements.bookstore_backtostoreButton_button());
	}
	
	public static void viewingprofile() throws IOException
	{
		CommonDef.waitnow();
		CommonDef.scrollJS(ElementPageElements.subMenu_Tab_Dynamic("Login"));
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Login"));
		CommonDef.waitnow();	
		CommonDef.clickJS(BookStorePageElements.bookstore_profile_link());
		CommonDef.waitnow();	
	}
	
	public static void deleteparticularbook(String bookName) throws IOException
	{
		CommonDef.clickJS(BookStorePageElements.bookstore_delete_one_book_dynamic(bookName));
		CommonDef.waitnow();
		CommonDef.assertTextEquals( BookStorePageElements.bookstore_deletebook_title(), "Delete Book");
		CommonDef.assertTextEquals( BookStorePageElements.bookstore_deletebookbody_question(), "Do you want to delete this book ?");
		CommonDef.clickJS(BookStorePageElements.bookstore_deletebookok_button());
		CommonDef.waitnow();
		CommonDef.assertTextEquals( CommonDef.getAlertText(), "Book deleted.");
		CommonDef.alertDismiss();
	}
	
	public static void deleteallbook() throws IOException
	{
		CommonDef.waitnow();
		CommonDef.clickJS(BookStorePageElements.bookstore_deleteallbook_button());
		CommonDef.assertTextEquals( BookStorePageElements.bookstore_deletebook_title(), "Delete All Books");
		CommonDef.assertTextEquals( BookStorePageElements.bookstore_deletebookbody_question(), "Do you want to delete all books ?");
		CommonDef.clickJS(BookStorePageElements.bookstore_deletebookok_button());
		CommonDef.waitnow();
		CommonDef.assertTextEquals( CommonDef.getAlertText(), "All Books deleted.");
		CommonDef.alertDismiss();
	}

	public static void logout() throws IOException {
		// TODO Auto-generated method stub
		CommonDef.waitnow();
		CommonDef.clickJS(BookStorePageElements.bookstore_logout_button());
		
	}
	
	
	

}
