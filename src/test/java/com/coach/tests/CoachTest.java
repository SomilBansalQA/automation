package com.coach.tests;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.WikiPageData;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class CoachTest {

    protected DSL dsl;
    protected  Map<String, List<Map<String,String>>> testData; 
    protected String[] browserSizes = {"1366x768"}; 
    protected String [] layoutTags = {"all"};
    
    @BeforeClass(groups={"desktop","mobile"})
    @Parameters({"browser", "locale"})
    public void __setUp(@Optional String browser, @Optional("US") String locale) {
        dsl = new DSL(this.getClass().getSimpleName(), browser);
        testData = dsl.testData.get(locale).data;
    }
    
    @BeforeMethod(groups = { "desktop", "mobile" })
	public void handleTestMethodName(Method method) {
		dsl.stepStartMessage(method.getName());
	}
	 	 	 
    @AfterClass(groups={"desktop","mobile"})
    public void zzTearDown(){
        dsl.closeBrowserSession();
        Reporter.log("User closes the application");
    }
	   
    @AfterMethod(groups={"desktop","mobile"})
    public void takeScreenshotonFailure(ITestResult result){
        dsl.takeScreenShotOnException(result);
    }
	 
}
