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


public class OpenPage{

    /**
     * The function opens the website https://test-with-a-smile.de and verifies
     * the logo and the footer
     * @param driver    The WebDriver used by the tests
     */
    public static void openTwsMain(WebDriver driver){
        driver.get("https://test-with-a-smile.de");

        // Initialize the TWS Main Page Object
        TwsMain poTwsMain = PageFactory.initElements(driver, TwsMain.class);

        // Verify the logo and footer
        VerifyMainFeatures.verifyLogo(driver);
        VerifyMainFeatures.verifyFooter(driver);
    }

}