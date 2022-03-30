package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.model.User;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;

import java.time.Duration;
import java.util.List;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

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

    @Test
    public void signUpTestWithOneMethod() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        User user = new User();
        user.setFirstName("Tomek");
        user.setLastName("Kabanos");
        user.setPhone("888761637");
        user.setEmail("aaba@" + (Math.random()*1000) + "aaba.pl");
        user.setPassword("#Password1");

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        //signUpPage.fillSignUpForm("Tomek", "Kabanos", "888761637", "aaba@aaba.pl",
        //        "#Password1");
        signUpPage.fillSignUpForm(user);

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        String headingText = loggedUserPage.getHeadingText();

        Assert.assertEquals(driver.getCurrentUrl(), "http://www.kurs-selenium.pl/demo/account/");
        Assert.assertEquals(headingText, "Hi, Tomek Kabanos");
    }

    @Test
    public void signUpEmptyTest() {
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpPerform();

        List<String> paragraphs = signUpPage.getAlertParagraphsText();

        SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(paragraphs.contains("The Email field is required."));
                softAssert.assertTrue(paragraphs.contains("The Password field is required."));
                softAssert.assertTrue(paragraphs.contains("The Password field is required."));
                softAssert.assertTrue(paragraphs.contains("The First name field is required."));
                softAssert.assertTrue(paragraphs.contains("The Last Name field is required"));
    }
}
