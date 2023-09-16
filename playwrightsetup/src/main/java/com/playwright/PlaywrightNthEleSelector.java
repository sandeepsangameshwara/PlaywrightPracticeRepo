
package com.playwright;

import com.microsoft.playwright.*;

public class PlaywrightNthEleSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.bigbasket.com/");
        Locator locator = page.locator("div.footer-links li a >> nth=0");
        System.out.println(locator.textContent());

        locator = page.locator("div.footer-links li a >> nth=-1");
        System.out.println(locator.textContent());

        locator = page.locator("div.footer-links li a >> nth=5");
        System.out.println(locator.textContent());

        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
