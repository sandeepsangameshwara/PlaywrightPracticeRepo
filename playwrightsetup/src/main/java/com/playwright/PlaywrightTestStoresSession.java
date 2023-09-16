package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightTestStoresSession {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // Code to relogin without entering the User credentials. Lets verify
        BrowserContext browserContext = browser
                .newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("loginCred.json")));
        Page page = browserContext.newPage();
        page.navigate("https://downloads.appzillon.com/");
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
