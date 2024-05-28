package org.example;

import org.example.log.Log;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {
    protected static PaymentAutomationTestMain paymentAutomationTestMain;
    protected static Log log;
    protected static String url;
    protected static String logoId;
    protected static String loginButtonId;
    protected static String userNameId;
    protected static String passwordId;
    protected static String enterButtonId;
    protected static String userProfileId;
    protected static String searchBarId;
    protected static String addToCartButtonId;
    protected static String cartButtonId;
    protected static String cartItem;
    protected static String checkoutButtonId;
    protected static String cardNumberId;
    protected static String expiryDateId;
    protected static String cvvId;
    protected static String payButtonId;
    protected static String confirmationMessageId;
    protected static String userName;
    protected static String password;
    protected static String searchProduct;
    protected static String cardNumber;
    protected static String expiryDate;
    protected static String cvv;

    @BeforeAll
    public static void setUp() {
        paymentAutomationTestMain = new PaymentAutomationTestMain();
        log = new Log();
        //örnek e-ticaret sitesi
        url = "https://www.example-shopping.com";
        logoId = "logo-id";
        loginButtonId = "login-button-id";
        userNameId = "user-name-input";
        passwordId = "password-input";
        enterButtonId = "enter-button-id";
        userProfileId = "user-profile-id";
        searchBarId = "search_bar_id";
        addToCartButtonId = "add-to-cart-button-id";
        cartButtonId = "cart-button-id";
        cartItem = "cart-item";
        checkoutButtonId = "checkout-button-id";
        cardNumberId = "card-number-input";
        expiryDateId = "expiry-date-input";
        cvvId = "cvv-input";
        payButtonId = "pay-button";
        confirmationMessageId = "confirmation-message-id";

        userName = "Yasemin Karahan Okur";
        password = "12345678";
        searchProduct = "Kupa Bardak";
        cardNumber = "1011711101111110"; // Geçersiz test kart numarası
        expiryDate = "09/28"; // Son kullanma tarihi
        cvv = "753"; // CVV numarası
    }

    @AfterAll
    public static void tearDown() {
        paymentAutomationTestMain.closeBrowser();
    }
}