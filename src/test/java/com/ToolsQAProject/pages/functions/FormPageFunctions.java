package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.ToolsQAProject.pages.elements.FormPageElements;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class FormPageFunctions {
	
	public static void formfillup(ExtentTest logger) throws IOException
	{	
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Practice Form"), logger);
		CommonDef.assertTextEquals(logger, FormPageElements.forms_heading_Text(), "Student Registration Form");
		CommonDef.sendKeys(FormPageElements.forms_firstname_Box(), "Hariharan", logger);
		CommonDef.sendKeys(FormPageElements.forms_lastname_Box(), "Arumugam", logger);
		CommonDef.sendKeys(FormPageElements.forms_email_Box(), "hari@gmail.com", logger);
		CommonDef.click(FormPageElements.forms_gender_radioButton("Male"), logger);
		CommonDef.sendKeys(FormPageElements.forms_number_Box(), "7639004000", logger);
		CommonDef.datepicker(FormPageElements.forms_dateOfBirthInput_Box(), "12", "march", "1995", logger);
		CommonDef.clickJS(FormPageElements.forms_subjectsContainer_Box(), logger);
		CommonDef.sendKeyswithEnter(FormPageElements.forms_subjectsContainer_Box(), "English", logger);
		CommonDef.scrollJS(FormPageElements.forms_hobbies_checkbox("Reading"), logger);
		CommonDef.clickJS(FormPageElements.forms_hobbies_checkbox("Reading"), logger);
		CommonDef.clickJS(FormPageElements.forms_hobbies_checkbox("Sports"), logger);
		CommonDef.uploadPic(FormPageElements.forms_upload_image(), "C:\\Users\\user\\scuba project\\NewTAFUpdated\\test-output\\images\\uploadimgae.png");
		CommonDef.sendKeys(FormPageElements.forms_currentAddress_box(), "Tirunelveli", logger);
		CommonDef.clickJS(FormPageElements.forms_state_box(), logger);
		CommonDef.sendKeyswithEnter(FormPageElements.forms_state_box(), "Rajasthan", logger);
		CommonDef.clickJS(FormPageElements.forms_city_box(), logger);
		CommonDef.sendKeyswithEnter(FormPageElements.forms_city_box(), "Jaipur", logger);
		CommonDef.click(FormPageElements.forms_Submit_Button(), logger);
		CommonDef.implicitWait();
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_Name_validate(), "Hariharan Arumugam");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_Email_validate(), "hari@gmail.com");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_gender_validate(), "Male");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_number_validate(), "7639004000");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_DOB_validate(), "12 March,1995");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_subject_validate(), "English");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_hobbies_validate(), "Reading, Sports");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_picture_validate(), "uploadimgae.png");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_address_validate(), "Tirunelveli");
		CommonDef.assertTextEquals(logger, FormPageElements.forms_Student_state_city_validate(), "Rajasthan Jaipur");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Form Filled SuccessFully", ExtentColor.GREEN));
		
	}

}
