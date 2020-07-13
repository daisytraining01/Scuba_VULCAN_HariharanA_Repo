package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.BookStorePageElements;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.aventstack.extentreports.ExtentTest;

public class BookStorePageFunctions {
	
	public static void bookstorelogin(ExtentTest logger) throws IOException
	{
		CommonDef.implicitWait();
		CommonDef.clickJS(BookStorePageElements.bookstore_login_button(), logger);
		//CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Login"),logger);
		CommonDef.sendKeys(BookStorePageElements.bookstore_username_Box(), "hari", logger);
		CommonDef.sendKeys(BookStorePageElements.bookstore_password_Box(), "hari@123", logger);
		CommonDef.clickJS(BookStorePageElements.bookstore_login_button(), logger);
		
	}
	
	public static void addingbooks(ExtentTest logger) throws IOException
	{
		CommonDef.clickJS(BookStorePageElements.select_book_link_dynamic("Git Pocket Guide"), logger);
		CommonDef.assertTextEquals(logger, BookStorePageElements.validate_book_name_dynamic("Git Pocket Guide"), "Git Pocket Guide");
		CommonDef.clickJS(BookStorePageElements.bookstore_addNewRecordButton_button(), logger);
		CommonDef.waitnow();
		CommonDef.assertTextEquals(logger, CommonDef.getAlertText(logger), "Book added to your collection.");
		CommonDef.alertDismiss(logger);
		CommonDef.clickJS(BookStorePageElements.bookstore_backtostoreButton_button(), logger);
		CommonDef.clickJS(BookStorePageElements.select_book_link_dynamic("Learning JavaScript Design Patterns"), logger);
		CommonDef.assertTextEquals(logger, BookStorePageElements.validate_book_name_dynamic("Learning JavaScript Design Patterns"), "Learning JavaScript Design Patterns");
		CommonDef.clickJS(BookStorePageElements.bookstore_addNewRecordButton_button(), logger);
		CommonDef.waitnow();
		CommonDef.assertTextEquals(logger, CommonDef.getAlertText(logger), "Book added to your collection.");
		CommonDef.alertDismiss(logger);
		CommonDef.clickJS(BookStorePageElements.bookstore_backtostoreButton_button(), logger);
	}
	
	public static void viewingprofile(ExtentTest logger) throws IOException
	{
		CommonDef.waitnow();
		CommonDef.scrollJS(ElementPageElements.subMenu_Tab_Dynamic("Login"), logger);
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Login"),logger);
		CommonDef.waitnow();	
		CommonDef.clickJS(BookStorePageElements.bookstore_profile_link(), logger);
		CommonDef.waitnow();	
	}
	
	public static void deleteparticularbook(String bookName,ExtentTest logger) throws IOException
	{
		CommonDef.clickJS(BookStorePageElements.bookstore_delete_one_book_dynamic(bookName), logger);
		CommonDef.waitnow();
		CommonDef.assertTextEquals(logger, BookStorePageElements.bookstore_deletebook_title(), "Delete Book");
		CommonDef.assertTextEquals(logger, BookStorePageElements.bookstore_deletebookbody_question(), "Do you want to delete this book ?");
		CommonDef.clickJS(BookStorePageElements.bookstore_deletebookok_button(), logger);
		CommonDef.waitnow();
		CommonDef.assertTextEquals(logger, CommonDef.getAlertText(logger), "Book deleted.");
		CommonDef.alertDismiss(logger);
	}
	
	public static void deleteallbook(ExtentTest logger) throws IOException
	{
		CommonDef.waitnow();
		CommonDef.clickJS(BookStorePageElements.bookstore_deleteallbook_button(), logger);
		CommonDef.assertTextEquals(logger, BookStorePageElements.bookstore_deletebook_title(), "Delete All Books");
		CommonDef.assertTextEquals(logger, BookStorePageElements.bookstore_deletebookbody_question(), "Do you want to delete all books ?");
		CommonDef.clickJS(BookStorePageElements.bookstore_deletebookok_button(), logger);
		CommonDef.waitnow();
		CommonDef.assertTextEquals(logger, CommonDef.getAlertText(logger), "All Books deleted.");
		CommonDef.alertDismiss(logger);
	}

	public static void logout(ExtentTest logger) throws IOException {
		// TODO Auto-generated method stub
		CommonDef.waitnow();
		CommonDef.clickJS(BookStorePageElements.bookstore_logout_button(), logger);
		
	}
	
	
	

}
