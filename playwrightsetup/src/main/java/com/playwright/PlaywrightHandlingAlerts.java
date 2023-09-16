package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightHandlingAlerts {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx=browser.newContext();
        Page page=brcx.newPage();
        page.onDialog(dialog->{
            String msgtext=dialog.message();
            System.out.println(msgtext);
            dialog.accept("This is sandeep");
            //dialog.dismiss();
        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.click("//button[text()='Click for JS Alert']");
        System.out.println(page.locator("#result").textContent());
        page.click("//button[text()='Click for JS Confirm']");
        System.out.println(page.locator("#result").textContent());
        page.click("//button[text()='Click for JS Prompt']");
        System.out.println(page.locator("#result").textContent());
        page.close();
        brcx.close();
        browser.close();
        playwright.close();      
    }
}
