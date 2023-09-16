package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightHandleWIndowPopup {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // Browser context won't share any cookies with each other.
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        // Navigate to different browser window and handle the popup
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Page twitterPage = page.waitForPopup(() -> {
            page.click("a[href='https://twitter.com/orangehrm?lang=en']");
        });
        twitterPage.waitForLoadState();
        System.out.println(twitterPage.title());
        twitterPage.close();

        // New context opened
        // Navigate to blank page and launch new URL
        BrowserContext context2 = browser.newContext();
        Page page2 = context2.newPage();
        System.out.println(page2.title());
        page2.navigate("https://www.google.com");
        System.out.println(page2.title());
        page2.close();
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
