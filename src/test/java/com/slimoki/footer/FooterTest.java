package com.slimoki.footer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;

public class FooterTest {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FooterTest.class);

    FooterConsts locators = new FooterConsts();
    WebDriver driver;

//    @BeforeEach

//    @AfterEach
    @Test
    public void verifyNavToFacebookPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alicj\\IdeaProjects\\test-repository\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        String heliPageTitle = "HELIMED Centrum Diagnostyki Obrazowej";
        String fbPageTitle = "Helimed | Facebook";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String url = "https://www.helimed.pl";
        driver.navigate().to(url);
        log.info("Navigate to " + url);
        Assertions.assertEquals(heliPageTitle, driver.getTitle(), "Page title is not: " + heliPageTitle);
        driver.findElement(By.cssSelector(locators.closeCookiesBtn)).click();
        driver.findElement(By.cssSelector(locators.fbBtn)).click();
        log.info("Log in to " + url);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Switch tab");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locators.fbRejectBtn)));
//        Assertions.assertEquals(fbPageTitle, driver.getTitle(), "Page title is not: " + fbPageTitle);
        driver.findElement(By.xpath(locators.fbRejectBtn)).click();
        driver.findElement(By.cssSelector(locators.fbCloseBtn)).click();
        Assertions.assertTrue(driver.getTitle().contains(fbPageTitle), "Page title is not: " + fbPageTitle);
        driver.quit();
    }
}
