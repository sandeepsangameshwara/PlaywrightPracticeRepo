package com.playwright;

import java.util.List;

import com.microsoft.playwright.*;

public class PlaywrightLocatorConcept {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://downloads.appzillon.com/");

        // Single Locator
        Locator signInButton = page.locator("text = Sign In");
        signInButton.click();
        page.close();

        // Multiple Locator :
        page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/");
        Locator contactSalesButton = page.locator("text = Company");
        // contactSalesButton.click();//Fails with multiple locator with same name error
        // Exception in thread "main" com.microsoft.playwright.PlaywrightException:
        // Error {
        // message='Error: strict mode violation: locator("text= Contact Sales")
        // resolved to 2 elements:
        // 1) <button class="btn btn-ohrm btn-free-demo">Contact Sales</button> aka
        // getByText("Contact Sales").first()
        // 2) <button class="btn btn-ohrm btn-free-demo">Contact Sales</button> aka
        // getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact
        // Sales"))

        contactSalesButton.first().click();// To click the first identified element

        page.navigate("https://www.orangehrm.com/");
        contactSalesButton = page.locator("text = Company");
        contactSalesButton.last().click();// To click the last identified element

        page.navigate("https://www.orangehrm.com/");
        contactSalesButton = page.locator("text = Company");
        System.out.println(contactSalesButton.count());// To check the total locators found with the same Locator

        
        page.navigate("https://www.orangehrm.com/en/contact-sales/");
        Locator countryLocator = page.locator("select#Form_getForm_Country option");
        System.out.println("No fo country : " + countryLocator.count());

        // traditional working with for loop
        for (int i = 0; i < countryLocator.count(); i++) {
            System.out.println("Traditional For Loop :"+countryLocator.nth(i).textContent());
        }

        // Traditional working with for loop
        List<String> countryStringList = countryLocator.allTextContents();
        for (String ele : countryStringList) {
            System.out.println("Using for all Loop :"+ele);
        }

        // Using lamda
        countryStringList.forEach(ele -> System.out.println("Using Lamda:"+ele));

        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

}
