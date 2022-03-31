package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {

    @FindBy(css = "input[name=firstname]")
    private WebElement inputFirstName;

    @FindBy(css = "input[name=lastname]")
    private WebElement inputLastName;

    @FindBy(css = "input[name=phone]")
    private WebElement inputPhone;

    @FindBy(css = "input[name=email]")
    private WebElement inputEmail;

    @FindBy(css = "input[name=password]")
    private WebElement inputPassword;

    @FindBy(css = "input[name=confirmpassword]")
    private WebElement inputConfirmPassword;

    @FindBy(css = ".signupbtn")
    private WebElement signUpBtn;

    @FindBy(css = "h3.RTL")
    private WebElement headingRegistrationText;

    @FindBy(css = ".alert-danger p")
    private List<WebElement> paragraphs;

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignUpPage setInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public SignUpPage setInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public SignUpPage setInputPhone(String phoneNumber) {
        inputPhone.sendKeys(phoneNumber);
        return this;
    }

    public SignUpPage setInputEmail(String emailAddress) {
        inputEmail.sendKeys(emailAddress);
        return this;
    }

    public SignUpPage setInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public SignUpPage setInputConfirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public LoggedUserPage signUpPerform() {
        signUpBtn.click();
        return new LoggedUserPage(driver);
    }

    public List<String> getAlertParagraphsText() {
        return paragraphs
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
