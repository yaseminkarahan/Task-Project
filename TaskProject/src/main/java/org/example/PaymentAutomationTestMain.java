package org.example;

import org.example.helper.WaitHepler;
import org.example.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PaymentAutomationTestMain {
    WebDriver driver;
    WaitHepler waitHepler;

    public PaymentAutomationTestMain() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yasemin\\Desktop\\Projects\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.waitHepler = new WaitHepler(driver);
    }

    //Site açılır
    public void openSite(String url) {
        driver.get(url);
    }

    // Site açıldı mı kontrolü
    public boolean isSiteOpenedSuccessfully(String logoId) {
        WebElement logo =  waitHepler.waitForElement(By.id(logoId));
        return logo.isDisplayed();
    }

    //Login sayfasına gidilir
    public void goToLoginPage(String loginButtonId) {
        WebElement loginButton = waitHepler.waitForElement(By.id(loginButtonId));
        loginButton.click();
    }

    //Kullanıcı bilgileri girilir
    public void enterUserDetails(String userNameId, String passwordId, String userName, String password) {
        WebElement userNameInput = waitHepler.waitForElement(By.id(userNameId));
        WebElement passWordInput = waitHepler.waitForElement(By.id(passwordId));

        userNameInput.sendKeys(userName);
        passWordInput.sendKeys(password);
    }

    // Giriş butonuna tıklanır.
    public void completeEnterUser(String enterButtonId) {
        WebElement enterButton = waitHepler.waitForElement(By.id(enterButtonId));
        enterButton.click();
    }

    // Login işlemi başarılı mı kontrolü
    public boolean isLoginSuccessful(String userProfileId) {
        WebElement userProfileElement = waitHepler.waitForElement(By.id(userProfileId)); // Kullanıcı profil öğesinin id'sini varsayalım
        return userProfileElement.isDisplayed();
    }

    //Arama yapılır
    public void search(String searchBarId, String searchKeyword) {
        WebElement searchBar = waitHepler.waitForElement(By.id(searchBarId));
        searchBar.sendKeys(searchKeyword);
        searchBar.sendKeys(Keys.ENTER); // Enter tuşuna basarak arama yapılabilir
    }

    //Ürün sepete eklenir
    public void addProductToCart(String addToCartButtonId) {
        WebElement addToCartButton = waitHepler.waitForElement(By.id(addToCartButtonId));
        addToCartButton.click();
    }

    //Sepet sayfasına gidilir
    public void goToCart(String cartButtonId) {
        WebElement cartButton = waitHepler.waitForElement(By.id(cartButtonId));
        cartButton.click();
    }

    //Sepette ürün kontrolü
    public boolean isProductAddedToCart(String cartItem) {
        List<WebElement> cartItems = waitHepler.waitForElements(By.className(cartItem));
        return cartItems.size() > 0;
    }

    //Ödeme sayfasına gidilir
    public void paymentToCheckout(String checkoutButtonId) {
        WebElement checkoutButton =  waitHepler.waitForElement(By.id(checkoutButtonId));
        checkoutButton.click();
    }

    // Ödeme kart bilgileri girilir
    public void enterPaymentDetails(String cardNumberId, String expiryDateId, String cvvId, String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberInput =  waitHepler.waitForElement(By.id(cardNumberId));
        WebElement expiryDateInput =  waitHepler.waitForElement(By.id(expiryDateId));
        WebElement cvvInput = waitHepler.waitForElement(By.id(cvvId));

        cardNumberInput.sendKeys(cardNumber);
        expiryDateInput.sendKeys(expiryDate);
        cvvInput.sendKeys(cvv);
    }

    // Ödeme tamamlanır
    public void completePayment(String payButtonId) {
        WebElement payButton =  waitHepler.waitForElement(By.id(payButtonId));
        payButton.click();
    }

    // Ödeme işlemi kontrolü
    public boolean verifyPaymentSuccess(String confirmationMessageId) {
        WebElement confirmationMessage =  waitHepler.waitForElement(By.id(confirmationMessageId));
        return confirmationMessage.isDisplayed();
    }

    // Tarayıcı kapatılır.
    public void closeBrowser() {
        driver.quit();
    }
}
