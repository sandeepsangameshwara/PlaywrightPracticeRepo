package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightTextSelector {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context=browser.newContext();
        Page page=context.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

        System.out.println(page.locator("text=New Customer").textContent());
        System.out.println(page.locator("'New Customer'").textContent());
        page.locator("a:has-text('Forgotten Password')").last().click();

        
    }
}
