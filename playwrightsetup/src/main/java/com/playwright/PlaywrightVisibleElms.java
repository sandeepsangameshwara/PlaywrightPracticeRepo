package com.playwright;

import com.microsoft.playwright.*;

public class PlaywrightVisibleElms {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.amazon.com/");

        page.locator("a:visible").allInnerTexts().forEach(ele-> System.out.println(ele));
        System.out.println(page.locator("img:visible").count());
        System.out.println(page.locator("img >> visible=false").count());
    }
}
