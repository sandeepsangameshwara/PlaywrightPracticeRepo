package com.playwright;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class PlaywrightFileUploadSupport {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx = browser.newContext();
        Page page = brcx.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        // Single file upload example
        Locator fileUploadEle = page.locator("input#filesToUpload");
        fileUploadEle.setInputFiles(Paths.get("loginCred.json"));
        Thread.sleep(4000);
        // Unselect the file upload selected
        fileUploadEle.setInputFiles(new Path[0]);
        Thread.sleep(4000);
        // Multiple File Upload example
        fileUploadEle.setInputFiles(new Path[] { Paths.get("loginCred.json"), Paths.get("pom.xml"), });
        Thread.sleep(4000);
        // Unselect the file upload selected
        fileUploadEle.setInputFiles(new Path[0]);
        Thread.sleep(4000);
        // To test on the fly generate and upload flow
        page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

        // On the fly file upload example
        Locator fileDynEle = page.locator("input[name='upfile']");
        fileDynEle.setInputFiles(
                new FilePayload("sandeep.txt", "text/plain", "This is sandeep here".getBytes(StandardCharsets.UTF_8)));
        page.click("input[value='Press']");
        Thread.sleep(4000);
        page.close();
        brcx.close();
        browser.close();
        playwright.close();
    }
}
