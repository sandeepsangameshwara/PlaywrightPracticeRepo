package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightStoreSession {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://downloads.appzillon.com/");
        page.fill("#Login__UserName", "CITICRM");
        page.fill("#Login__Password", "CITICRM");
        page.click("a:text('Sign In')");
        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("loginCred.json")));
        page.click("#AppzillonLogoutBtn");
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();

    }
}
