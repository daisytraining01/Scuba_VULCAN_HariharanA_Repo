package com.ToolsQAProject.pages.elements;

import org.openqa.selenium.By;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.commonDef.CommonDef.Locators;

public class BookStorePageElements {
	
	public static By bookstore_username_Box() {
        return CommonDef.locatorValue(Locators.ID,"userName");
    }
	
	public static By bookstore_password_Box() {
        return CommonDef.locatorValue(Locators.ID,"password");
    }
	
	public static By bookstore_login_button() {
        return CommonDef.locatorValue(Locators.ID,"login");
    }
	
	public static By bookstore_gotostore_button() {
        return CommonDef.locatorValue(Locators.ID,"gotoStore");
    }
	
	public static By select_book_link_dynamic(String bookname) {
        return CommonDef.locatorValue(Locators.XPATH,"//a[contains(text(),'"+bookname+"')]");
    }
	
	public static By validate_book_name_dynamic(String bookname) {
        return CommonDef.locatorValue(Locators.XPATH,"//label[contains(text(),'"+bookname+"')]");
    }
	
	public static By bookstore_addNewRecordButton_button() {
        return CommonDef.locatorValue(Locators.XPATH,"//button[contains(text(),'Add To Your Collection')]");
    }
	
	public static By bookstore_backtostoreButton_button() {
        return CommonDef.locatorValue(Locators.XPATH,"//button[contains(text(),'Back To Book Store')]");
    }
	
	public static By bookstore_profile_link() {
        return CommonDef.locatorValue(Locators.XPATH,"//a[contains(text(),'profile')]");
    }
	
	public static By bookstore_delete_one_book_dynamic(String bookname) {
        return CommonDef.locatorValue(Locators.XPATH,"//a[contains(text(),'"+bookname+"')]//parent::span//parent::div//parent::div//following-sibling::div[3]//span");
    }
	
	public static By bookstore_deletebook_title() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='example-modal-sizes-title-sm']");
    }
	
	public static By bookstore_deletebookbody_question() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[@class='modal-body']");
	}
	
	public static By bookstore_deletebookok_button() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='closeSmallModal-ok']");
    }
	
	public static By bookstore_deletebookcancel_button() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='closeSmallModal-cancel']");
    }
	
	public static By bookstore_deleteallbook_button() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Delete All Books')]");
    }
	
	public static By bookstore_logout_button() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Log out')]");
    }
	
}
