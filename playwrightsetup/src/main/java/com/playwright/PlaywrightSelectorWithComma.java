package com.playwright;

import com.microsoft.playwright.*;

public class PlaywrightSelectorWithComma {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.orangehrm.com/en/contact-sales/");
        Locator locator=page.locator("a:has-text('Solutions') , a:has-text('Resources') ");
        locator.allTextContents().forEach(ele->System.out.println(ele));

        
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
