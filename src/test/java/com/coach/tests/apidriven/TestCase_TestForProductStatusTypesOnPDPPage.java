package com.coach.tests.apidriven;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.coach.qa.automation.dsl.api.Categories;
import com.coach.qa.automation.dsl.api.ProductSearch;
import com.coach.qa.automation.dsl.api.SearchSuggestion;
import com.coach.qa.automation.dsl.templates.Category;

import com.coach.qa.automation.dsl.templates.Product;

import java.util.ArrayList;
import org.testng.Assert;

import org.testng.annotations.*;

/**
 *
 * @author Ramandeep <RamandeepsSingh@QAInfoTech.com>
 */
public class TestCase_TestForProductStatusTypesOnPDPPage extends CoachTestCase{

    String url;
    
    @BeforeClass
    public void launchApplication(){
        url = dsl.testData.get("d1").data.get("BASE URL").get(0).get("URL");
        dsl.launchApplication(url);
    }
    
    @Test
    public void unavailableProductPDP() throws Exception{
        ProductSearch ps = new ProductSearch(dsl);
        dsl.searchProduct(ps.findProductByNotOrderable().id);
        
        Assert.assertEquals(dsl.prodctdetails.status(), "item unavailable");
    }
}
