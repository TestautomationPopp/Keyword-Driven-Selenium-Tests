/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.testframework.tests;

import com.tws.testframework.framework.Browser;
import com.tws.testframework.dataprovider.SearchProvider;

import com.tws.testframework.keywords.*;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class FirstTest{

    // Create a public variable for the browser class to call the driver
    public com.tws.testframework.framework.Browser browser;
    public static String [][] fileData;

    /**
     * The test case opens the website https://test-with-a-smile.de and verify, that the logo is displayed
     * 
     * @param browsername   The browser defined in the data provider given from the -Dbrowsers parameter of the maven call
     * @throws Exception
     */
    @Test(dataProvider = "search-data-provider", dataProviderClass = SearchProvider.class)
    private void testCase(String browsername, String searchTerm, String searchResultString, String firstResultHeader, String firstResultSummary) throws Exception{
        browser = new Browser(browsername, 10);

        OpenPage.openTwsMain(browser.driver);

        Search.searchForTerm(browser.driver, searchTerm);

        Search.checkFirstSearchResult(browser.driver, searchResultString, firstResultHeader, firstResultSummary);
        
    }
    
    /**
     * The after method will close the browser when the execution of the test method is done.
     */
    @AfterMethod
    private void closeBrowsers(){
        browser.driver.quit();
    }
}