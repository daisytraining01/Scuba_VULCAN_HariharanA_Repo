package com.CucumberProject;

import com.maveric.core.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/java/com/CucumberProject/features"},
        glue ={ "com.CucumberProject.stepDefinitions"},
		tags = "@me"
)
public class RunnerClassCucumber extends CucumberBaseTest {


}