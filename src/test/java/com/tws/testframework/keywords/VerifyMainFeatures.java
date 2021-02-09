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


public class VerifyMainFeatures{

    /**
     * The function verifys that the logo is displayed
     * @param driver    The WebDriver used by the tests
     */
    public static void verifyLogo(WebDriver driver){
        TwsMain poTwsMain = PageFactory.initElements(driver, TwsMain.class);

        Assert.assertEquals(true, poTwsMain.logo.isDisplayed());
    }

    /**
     * The function verifies the link texts in the footer
     * @param driver    The WebDriver used by the tests
     */
    public static void verifyFooter(WebDriver driver){
        TwsMain poTwsMain = PageFactory.initElements(driver, TwsMain.class);

        Assert.assertEquals("Impressum", poTwsMain.impressum.getText());
        Assert.assertEquals("Data protection", poTwsMain.dataProtection.getText());
        Assert.assertEquals("About the author", poTwsMain.aboutTheAuthor.getText());
    }

}