package com.playwright;

import com.microsoft.playwright.*;

/**
 * Hello world!
 *
 */
public class PlaywrightBrowserContext {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx1 = browser.newContext();
        Page page1 = brcx1.newPage();
        page1.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
        page1.fill("#Form_getForm_FullName", "Sandeep");
        System.out.println(page1.title());

        BrowserContext brcx2 = browser.newContext();
        Page page2 = brcx2.newPage();
        page2.navigate("https://www.myntra.com/");
        page2.getByPlaceholder("Search for products, brands and more").fill("Tops");
        System.out.println(page2.title());

        BrowserContext brcx3 = browser.newContext();
        Page page3 = brcx3.newPage();
        page3.navigate("https://www.google.com/");
        page3.fill("#APjFqb", "Sandeep");
        System.out.println(page3.title());

        page1.close();
        brcx1.close();

        page2.close();
        brcx2.close();

        page3.close();
        brcx3.close();
        
        browser.close();
        playwright.close();

    }
}