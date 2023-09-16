package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.Dimension;
import java.awt.Toolkit;

public class PlaywrightMaximizeBrowser {
    public static void main(String[] args) {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)dimension.getWidth();
        int height=(int)dimension.getHeight();
        System.out.println(width+":"+height);
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx=browser.newContext(new Browser.NewContextOptions().setViewportSize(width , height));
        Page page=brcx.newPage();
        page.navigate("https://www.google.com/");
        page.close();
        brcx.close();
        browser.close();
        playwright.close();
    }
}
