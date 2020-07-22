package com.ToolsQAProject.pages.functions;

import java.io.IOException;
import java.util.HashMap;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.ToolsQAProject.pages.elements.FormPageElements;
import com.relevantcodes.extentreports.ExtentTest;

public class FormPageFunctions {
	
	public static void formfillup(HashMap<Object, Object> testData) throws IOException
	{	
		CommonDef.implicitWait();
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Practice Form"));
		CommonDef.assertTextEquals( FormPageElements.forms_heading_Text(), "Student Registration Form");
		CommonDef.sendKeys(FormPageElements.forms_firstname_Box(),testData.get("FirstName"));
		CommonDef.sendKeys(FormPageElements.forms_lastname_Box(), testData.get("LastName"));
		CommonDef.sendKeys(FormPageElements.forms_email_Box(), testData.get("Email"));
		CommonDef.click(FormPageElements.forms_gender_radioButton(testData.get("Gender").toString()));
		CommonDef.sendKeys(FormPageElements.forms_number_Box(),testData.get("MobileNumber"));
		CommonDef.datepicker(FormPageElements.forms_dateOfBirthInput_Box(), testData.get("DateOfBorn").toString(), testData.get("MonthOfBorn").toString(), testData.get("YearOfBorn").toString());
		CommonDef.waitnow();
		CommonDef.clickJS(FormPageElements.forms_subjectsContainer_Box());
		CommonDef.sendKeyswithEnter(FormPageElements.forms_subjectsContainer_Box(), testData.get("Subject").toString());
		CommonDef.scrollJS(FormPageElements.forms_hobbies_checkbox(testData.get("Hobbies").toString()));
		CommonDef.clickJS(FormPageElements.forms_hobbies_checkbox(testData.get("Hobbies").toString()));
		CommonDef.uploadPic(FormPageElements.forms_upload_image(), "C:\\Users\\user\\scuba project\\NewTAFUpdated\\src\\test\\java\\com\\ToolsQAProject\\resource\\imagestoupload\\"+testData.get("ImageName"));
		CommonDef.sendKeys(FormPageElements.forms_currentAddress_box(), testData.get("Address"));
		CommonDef.clickJS(FormPageElements.forms_state_box());
		CommonDef.sendKeyswithEnter(FormPageElements.forms_state_box(), testData.get("State").toString());
		CommonDef.clickJS(FormPageElements.forms_city_box());
		CommonDef.sendKeyswithEnter(FormPageElements.forms_city_box(), testData.get("City").toString());
		CommonDef.click(FormPageElements.forms_Submit_Button());
		CommonDef.implicitWait();
		CommonDef.assertTextEquals( FormPageElements.forms_Student_Name_validate(), testData.get("FirstName").toString()+" "+testData.get("LastName").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_Email_validate(), testData.get("Email").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_gender_validate(), testData.get("Gender").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_number_validate(), testData.get("MobileNumber").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_DOB_validate(), testData.get("DateOfBorn").toString()+" "+testData.get("MonthOfBorn").toString()+","+testData.get("YearOfBorn").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_subject_validate(), testData.get("Subject").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_hobbies_validate(), testData.get("Hobbies").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_picture_validate(), testData.get("ImageName").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_address_validate(),  testData.get("Address").toString());
		CommonDef.assertTextEquals( FormPageElements.forms_Student_state_city_validate(),  testData.get("State").toString()+" "+testData.get("City").toString());
		
		
	}

}
