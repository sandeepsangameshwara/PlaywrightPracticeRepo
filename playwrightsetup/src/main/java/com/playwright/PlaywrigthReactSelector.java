package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrigthReactSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://opensource.fb.com/");
        Locator locator = page.locator("_react=j[title='Site Map'] >> a");
        locator.allInnerTexts().stream().forEach(ele -> System.out.println(ele));
        locator = page.locator("_react=J[title='Blog'] >> a");
        locator.click();
        
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
