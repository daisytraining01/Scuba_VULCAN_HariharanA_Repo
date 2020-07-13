package com.ToolsQAProject.pages.elements;

import org.openqa.selenium.By;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.commonDef.CommonDef.Locators;

public class FormPageElements {
	
	public static By forms_firstname_Box() {
        return CommonDef.locatorValue(Locators.ID,"firstName");
    }
	
	public static By forms_lastname_Box() {
        return CommonDef.locatorValue(Locators.ID,"lastName");
    }
	
	public static By forms_email_Box() {
        return CommonDef.locatorValue(Locators.ID,"userEmail");
    }
	
	public static By forms_heading_Text() {
        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='userForm']//parent::div//h5");
    }
	
	public static By forms_gender_radioButton(String radiobuttonName) {
		 return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+radiobuttonName+"')]");
    }
	
	public static By forms_number_Box() {
        return CommonDef.locatorValue(Locators.ID,"userNumber");
    }
	
	public static By forms_dateOfBirthInput_Box() {
        return CommonDef.locatorValue(Locators.ID,"dateOfBirthInput");
    }
	
	public static By forms_subjectsContainer_Box() {
        return CommonDef.locatorValue(Locators.ID,"subjectsInput");
    }
	
	public static By forms_hobbies_checkbox(String radiobuttonName) {
		 return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+radiobuttonName+"')]");
   }
	
	public static By forms_upload_image() {
        return CommonDef.locatorValue(Locators.ID,"uploadPicture");
    }
	
	public static By forms_currentAddress_box() {
        return CommonDef.locatorValue(Locators.ID,"currentAddress");
    }
	
	public static By forms_state_box() {
        return CommonDef.locatorValue(Locators.ID,"react-select-3-input");
    }
	
	public static By forms_city_box() {
        return CommonDef.locatorValue(Locators.ID,"react-select-4-input");
    }
	
	 public static By forms_Submit_Button() {
	        return CommonDef.locatorValue(Locators.ID,"submit");
	    }
	 
	 public static By forms_Student_Name_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Student Name')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_Email_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Student Email')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_gender_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Gender')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_number_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Mobile')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_DOB_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Date of Birth')]//following-sibling::td");
	    }
	
	 public static By forms_Student_subject_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Subjects')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_hobbies_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Hobbies')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_address_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Address')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_state_city_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'State and City')]//following-sibling::td");
	    }
	 
	 public static By forms_Student_picture_validate() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'Picture')]//following-sibling::td");
	    }
	
}
