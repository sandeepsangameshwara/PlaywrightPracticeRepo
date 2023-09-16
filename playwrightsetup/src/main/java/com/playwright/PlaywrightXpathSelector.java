package com.playwright;

import com.microsoft.playwright.*;

public class PlaywrightXpathSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.myntra.com/");
        Locator locator = page.locator("//input[@class='desktop-searchBar']");
        locator.fill("Churidar");
        page.keyboard().press("Enter");

        page.navigate("https://www.myntra.com/");
        locator = page.locator("xpath=//a[contains(text(),'Myntra')]");
        System.out.println(locator.count());
        locator.allInnerTexts().stream().forEach(ele -> System.out.println(ele));
        
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        locator = page.locator("//a[text()='Joe.Root']//parent::td/preceding-sibling::td/input[@type='checkbox']");
        locator.click();

        locator = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
        for(int i=0;i>locator.count();i++){
            locator.nth(i).click();
        }

        locator = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
        for(int i=0;i>locator.count();i++){
            locator.nth(i).click();
        }
        page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
        page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
        

        
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
