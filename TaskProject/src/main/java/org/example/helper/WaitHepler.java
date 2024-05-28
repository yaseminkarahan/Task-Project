package org.example.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHepler {
    public WebDriverWait wait;

    public WaitHepler(WebDriver driver) {
        this.wait = new WebDriverWait(driver,  Duration.ofSeconds(10)); // 10 saniye zaman aşımı süresi
    }

    public WebElement waitForElement(By locator) throws TimeoutException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForElements(By locator) throws TimeoutException {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
