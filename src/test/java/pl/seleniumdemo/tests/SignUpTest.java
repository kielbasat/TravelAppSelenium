package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;

import java.time.Duration;
import java.util.List;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        LoggedUserPage loggedUserPage = new HotelSearchPage(driver)
                .openSignUpForm()
                .setInputFirstName("Tomek")
                .setInputLastName("Kabanos")
                .setInputPhone("888761637")
                .setInputEmail("test@" + (Math.random() * 1000) + ".pl")
                .setInputPassword("#DupaCycki1")
                .setInputConfirmPassword("#DupaCycki1")
                .signUpPerform();

        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Tomek Kabanos");
    }

    @Test
    public void signUpEmptyTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        SignUpPage signUpPage = new HotelSearchPage(driver)
                .openSignUpForm();
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
