package com.slimoki.footer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class FooterTest {

    FooterConsts locators = new FooterConsts();
    WebDriver driver;

//    @BeforeEach

//    @AfterEach

    @Test
    public void verifyNavToFacebookPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\gitHub\\test-repository-helimed\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        String heliPageTitle = "HELIMED Centrum Diagnostyki Obrazowej";
        String fbPageTitle = "Helimed | Facebook";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.navigate().to("https://www.helimed.pl");
        Assertions.assertEquals(heliPageTitle, driver.getTitle(), "Page title is not: " + heliPageTitle);
        driver.findElement(By.cssSelector(locators.closeCookiesBtn)).click();
        driver.findElement(By.cssSelector(locators.fbBtn)).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locators.fbRejectBtn)));
        Assertions.assertEquals(fbPageTitle, driver.getTitle(), "Page title is not: " + fbPageTitle);
        driver.findElement(By.xpath(locators.fbRejectBtn)).click();
        driver.findElement(By.cssSelector(locators.fbCloseBtn)).click();
        Assertions.assertEquals(fbPageTitle, driver.getTitle(), "Page title is not: " + fbPageTitle);
        driver.quit();
    }
}
