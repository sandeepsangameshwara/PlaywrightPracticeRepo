package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightScopeLocator {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
        Locator tableRowLocator = page.locator("table#example tr");
        tableRowLocator.locator(":scope",new Locator.LocatorOptions().setHasText("Ashton Cox")).locator(".select-checkbox").click();

        tableRowLocator.locator(":scope").allInnerTexts().stream().forEach(ele->System.out.println(ele));

        page.navigate("https://primeng.org/table");
        tableRowLocator = page.locator("table#pn_id_18-table tr");
        tableRowLocator.locator(":scope",new Locator.LocatorOptions().setHasText("f230fh0g3")).locator(".p-checkbox-box").click();

        tableRowLocator.locator(":scope").allInnerTexts().stream().forEach(ele->System.out.println(ele));

        
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
