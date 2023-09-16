
package com.playwright;

import com.microsoft.playwright.*;

public class PlaywrighRelativeSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://selectorshub.com/xpath-practice-page/");
        Locator locator = page.locator("td:left-of(:text('Joe.Root'))");
        locator.allTextContents().forEach(ele -> System.out.println("Left Of ex: "+ele));
        locator = page.locator("td:right-of(:text('Joe.Root'))");
        locator.allTextContents().forEach(ele -> System.out.println("Right Of ex: "+ele));
        locator = page.locator("td:above(:text('Joe.Root'))");
        locator.allTextContents().forEach(ele -> System.out.println("Above ex: "+ele));
        locator = page.locator("td:below(:text('Joe.Root'))");
        locator.allTextContents().forEach(ele -> System.out.println("Below ex: "+ele));
        locator = page.locator("td:near(:text('Joe.Root'))");
        locator.allTextContents().forEach(ele -> System.out.println("Near ex: "+ele));
        locator = page.locator("td:near(:text('Joe.Root'),20)");
        locator.allTextContents().forEach(ele -> System.out.println("Near ex with 100 px: "+ele));

        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
