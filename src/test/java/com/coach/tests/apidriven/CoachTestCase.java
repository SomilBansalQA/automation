package com.coach.tests.apidriven;


import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeMethod;

public class CoachTestCase {

    public DSL dsl;
    public Map testData;

    @BeforeClass
    @Parameters("browser")
    public void __setUpClass(@Optional String browser) throws Exception {
        dsl = new DSL(this.getClass().getSimpleName(), browser);
        testData = dsl.testData;
    }

    @AfterClass
    public void ztearDownClass() throws Exception {
        dsl.closeBrowserSession();
    }
    
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws Exception{
        dsl.takeScreenShotOnException(testResult);
    }
}
