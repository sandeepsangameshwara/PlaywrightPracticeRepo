package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFrames {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("http://www.londonfreelance.org/courses/frames/");

        System.out.println(page.frameLocator("//frame[@name='main']").locator("h2").textContent());
        System.out.println(page.frame("main").locator("h2").textContent());

        page.navigate("https://www.formsite.com/templates/human-resources/employment-application-form/");
        page.locator("//img[@title='Employment-Application-Forms-and-Examples']").click();
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-2")
                .fill("Sandeep Sangameshwara");

    }
}
