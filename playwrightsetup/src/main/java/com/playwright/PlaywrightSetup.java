package com.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

/**
 * Hello world!
 *
 */
public class PlaywrightSetup {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.google.com/");
        String title = page.title();
        System.out.println("chromium Page title : " + title);
        String url = page.url();
        System.out.println("chromium URL launched :" + url);
        page.close();
        browser.close();

        // Testing for webkit driver
        browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        title = page.title();
        System.out.println("webkit Page title : " + title);
        url = page.url();
        System.out.println("webkit URL launched :" + url);
        page.close();
        browser.close();

        // Testing for firefox driver
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        title = page.title();
        System.out.println("firefox Page title : " + title);
        url = page.url();
        System.out.println("firefox URL launched :" + url);
        page.close();
        browser.close();

        // Testing for microsoft edge driver
        LaunchOptions lp=new LaunchOptions().setChannel("chrome");
        lp.setHeadless(false);
        browser = playwright.chromium().launch(lp);
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        title = page.title();
        System.out.println("chrome Page title : " + title);
        url = page.url();
        System.out.println("chrome URL launched :" + url);
        page.close();
        browser.close();

        // Testing for microsoft edge driver
        lp=new LaunchOptions().setChannel("msedge");
        lp.setHeadless(false);
        browser = playwright.chromium().launch(lp);
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        title = page.title();
        System.out.println("ms-edge Page title : " + title);
        url = page.url();
        System.out.println("ms-edge URL launched :" + url);
        page.close();
        browser.close();

        // Testing for microsoft edge driver
        lp=new LaunchOptions().setChannel("firefox");
        lp.setHeadless(false);
        browser = playwright.firefox().launch(lp);
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        title = page.title();
        System.out.println("firefox Page title : " + title);
        url = page.url();
        System.out.println("firefox URL launched :" + url);
        page.close();
        browser.close();

        playwright.close();
    }
}
