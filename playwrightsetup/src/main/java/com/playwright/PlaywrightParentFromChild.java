package com.playwright;

import com.microsoft.playwright.*;

public class PlaywrightParentFromChild {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.orangehrm.com/en/contact-sales/");
        Locator locator=page.locator("select#Form_getForm_Country:has(option[value='India'])");
        locator.allTextContents().forEach(ele->System.out.println(ele));

        page.navigate("https://www.amazon.in//");
        locator=page.locator("div.navFooterLinkCol:has(a[href='https://amazon.jobs'])");
        locator.allTextContents().forEach(ele->System.out.println(ele));

        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
