package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFileDownload {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx = browser.newContext();
        Page page = brcx.newPage();

        page.navigate("https://repo1.maven.org/maven2/org/springframework/spring-core/6.0.11/");
        Download download = page.waitForDownload(() -> {
            page.click("a[title='spring-core-6.0.11-javadoc.jar']");
        });
        // download.cancel();
        System.out.println("Any failure reason :" + download.failure());
        System.out.println("Page title :" + download.page().title());
        System.out.println("URL :" + download.url());
        System.out.println("Name in server:" + download.suggestedFilename());
        if (download.failure() == null) {
            System.out.println("Temp path downloaded in : " + download.path().toString());
            download.saveAs(Paths.get("sandeep-javadoc.zip"));
        }
        Thread.sleep(4000);
        page.close();
        brcx.close();
        browser.close();
        playwright.close();

    }
}
