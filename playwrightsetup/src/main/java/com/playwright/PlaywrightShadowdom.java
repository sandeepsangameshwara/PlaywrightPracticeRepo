package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightShadowdom {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Page --> DOM --> Shadowdom --> element
        page.navigate("https://books-pwakit.appspot.com/");

        page.locator("book-app[apptitle='BOOKS'] #input").fill("Kannada");
        System.out.println(page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent());

        // Page --> DOM -->Iframe --> Shadowdom --> element
        page.navigate("https://selectorshub.com/xpath-practice-page/");

        System.out.println(page.frameLocator("//iframe[contains(@id,'frame-one')]")
                .locator("book-app[apptitle='BOOKS'] .books-desc").textContent());

    }
}
