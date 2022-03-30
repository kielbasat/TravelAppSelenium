package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;

import java.time.Duration;

public class RegisterFormTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        driver.get("http://www.kurs-selenium.pl/demo/register");

        String lastname = "Kabanos";

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setInputFirstName("Tomek");
                signUpPage.setInputLastName("Kabanos");
                signUpPage.setInputPhone("888761637");
                signUpPage.setInputEmail("test@" + (Math.random()*1000) + ".pl");
                signUpPage.setInputPassword("#DupaCycki1");
                signUpPage.setInputConfirmPassword("#DupaCycki1");
                signUpPage.signUpPerform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.RTL")));
        String registrationText = driver.findElement(By.cssSelector("h3.RTL")).getText();

        Assert.assertEquals(registrationText, "Hi, Tomek Kabanos");
        Assert.assertTrue(registrationText.contains(lastname));

    }

}
