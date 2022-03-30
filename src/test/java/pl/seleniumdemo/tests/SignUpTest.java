package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;

import java.time.Duration;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setInputFirstName("Tomek");
        signUpPage.setInputLastName("Kabanos");
        signUpPage.setInputPhone("888761637");
        signUpPage.setInputEmail("test@" + (Math.random() * 1000) + ".pl");
        signUpPage.setInputPassword("#DupaCycki1");
        signUpPage.setInputConfirmPassword("#DupaCycki1");
        signUpPage.signUpPerform();

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        String headingText = loggedUserPage.getHeadingText();

        Assert.assertEquals(driver.getCurrentUrl(), "http://www.kurs-selenium.pl/demo/account/");
        Assert.assertEquals(headingText, "Hi, Tomek Kabanos");
    }

}
