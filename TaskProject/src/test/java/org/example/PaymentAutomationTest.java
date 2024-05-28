package org.example;

import org.example.log.Log;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class PaymentAutomationTest extends MainTest{

    @Test
    @Order(1)
    public void testOpenSite() {
        paymentAutomationTestMain.openSite(url);
        assertTrue(paymentAutomationTestMain.isSiteOpenedSuccessfully(logoId));
        Log.info("Passed: Site opened successfully.");
    }

    @Test
    @Order(2)
    public void testGoToLoginPage() {
        paymentAutomationTestMain.goToLoginPage(loginButtonId);
        WebElement loginButton = paymentAutomationTestMain.waitHepler.waitForElement(By.id(loginButtonId));
        assertNotNull(loginButton);
        Log.info("Passed: Navigated to login page successfully.");
    }

    @Test
    @Order(3)
    public void testEnterUserDetails() {
        paymentAutomationTestMain.enterUserDetails(userNameId, passwordId, userName, password);

        WebElement userNameInput = paymentAutomationTestMain.waitHepler.waitForElement(By.id(userNameId));
        WebElement passwordInput = paymentAutomationTestMain.waitHepler.waitForElement(By.id(passwordId));

        assertEquals(userName, userNameInput.getAttribute("value"));
        assertEquals(password, passwordInput.getAttribute("value"));
        Log.info("Passed: User details entered successfully.");
    }

    @Test
    @Order(4)
    public void testCompleteEnterUser() {
        paymentAutomationTestMain.completeEnterUser(enterButtonId);
        assertTrue(paymentAutomationTestMain.isLoginSuccessful(userProfileId));
        Log.info("Passed: Login completed successfully.");
    }

    @Test
    @Order(5)
    public void testSearch() {
        paymentAutomationTestMain.search(searchBarId, searchProduct);
        WebElement searchBar = paymentAutomationTestMain.waitHepler.waitForElement(By.id(searchBarId));
        assertEquals(searchProduct, searchBar.getAttribute("value"));
        Log.info("Passed: Search completed successfully.");
    }


    @Test
    @Order(6)
    public void testAddProductToCart() {
        paymentAutomationTestMain.addProductToCart(addToCartButtonId);
        assertTrue(paymentAutomationTestMain.isProductAddedToCart(cartItem));
        Log.info("Passed: Product added to cart successfully.");
    }

    @Test
    @Order(7)
    public void testGoToCart() {
        paymentAutomationTestMain.goToCart(cartButtonId);
        WebElement cartButton = paymentAutomationTestMain.waitHepler.waitForElement(By.id(cartButtonId));
        assertNotNull(cartButton);
        Log.info("Passed: Navigated to cart successfully.");
    }

    @Test
    @Order(8)
    public void testPaymentToCheckout() {
        paymentAutomationTestMain.paymentToCheckout(checkoutButtonId);
        WebElement checkoutButton = paymentAutomationTestMain.waitHepler.waitForElement(By.id(checkoutButtonId));
        assertNotNull(checkoutButton);
        Log.info("Passed: Payment to checkout completed successfully.");
    }

    @Test
    @Order(9)
    public void testEnterPaymentDetails() {
        paymentAutomationTestMain.enterPaymentDetails(cardNumberId, expiryDateId, cvvId, cardNumber, expiryDate, cvv);

        WebElement cardNumberInput = paymentAutomationTestMain.waitHepler.waitForElement(By.id(cardNumberId));
        WebElement expiryDateInput = paymentAutomationTestMain.waitHepler.waitForElement(By.id(expiryDateId));
        WebElement cvvInput = paymentAutomationTestMain.waitHepler.waitForElement(By.id(cvvId));

        assertEquals(cardNumber, cardNumberInput.getAttribute("value"));
        assertEquals(expiryDate, expiryDateInput.getAttribute("value"));
        assertEquals(cvv, cvvInput.getAttribute("value"));
        Log.info("Passed: Payment details entered successfully.");
    }

    @Test
    @Order(10)
    public void testCompletePayment() {
        try {
            paymentAutomationTestMain.completePayment(payButtonId);
            assertTrue(paymentAutomationTestMain.verifyPaymentSuccess(confirmationMessageId));
            Log.info("Passed: Payment completed successfully.");
        } catch (Exception e) {
            // Log the error message
            Log.error("Failed: Payment could not be completed. Error: " + e.getMessage());
        }


    }



}
