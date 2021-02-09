/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.testframework.keywords;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.tws.testframework.pageobjects.*;


public class Search{

    /**
     * The function gets a search term, writes it in the search field and clicks on the search button
     * @param driver        The WebDriver used by the tests
     * @param searchTerm    The term to search for
     */
    public static void searchForTerm(WebDriver driver, String searchTerm){
        TwsMain poTwsMain = PageFactory.initElements(driver, TwsMain.class);
        poTwsMain.inp_search.sendKeys(searchTerm);
        poTwsMain.btn_search.click();
    }

    /**
     * The function checks the result string, the headline of the first result and the summary
     * @param driver                The WebDriver used by the tests
     * @param searchResultString    The string of the search result
     * @param firstResultHeader     The header of the first result
     * @param firstResultSummary    The summary of the first result
     */
    public static void checkFirstSearchResult(WebDriver driver, String searchResultString, String firstResultHeader, String firstResultSummary){
        // Initialize the Search Result Page Object
        SearchResult poSearchResult = PageFactory.initElements(driver, SearchResult.class);
        
        // Verify the search results
        Assert.assertEquals(searchResultString, poSearchResult.searchResultText.getText());
        Assert.assertEquals(firstResultHeader, poSearchResult.firstResultHeader.getText());
        Assert.assertEquals(firstResultSummary, poSearchResult.firstResultSummary.getText());
    }

}