
package com.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.nio.file.Paths;

public class PlaywrightTraceviewer {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
          .setHeadless(false));
      BrowserContext context = browser.newContext();
      context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("CapsLock");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("SANDEEP");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("SANDEEP@RANDOM.COM");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("DEMO");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").press("Tab");
      page.frameLocator("#microfe-popup-login")
          .getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
      page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON).first().click();
      page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
      page.close();
      context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
      browser.close();
      playwright.close();
    }
  }
}