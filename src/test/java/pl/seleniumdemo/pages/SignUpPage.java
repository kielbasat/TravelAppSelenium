package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public SignUpPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void setInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }
    public void setInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }
    public void setInputPhone(String phoneNumber) {
        inputPhone.sendKeys(phoneNumber);
    }
    public void setInputEmail(String emailAddress) {
        inputEmail.sendKeys(emailAddress);
    }
    public void setInputPassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void setInputConfirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
    }
    public void signUpPerform() {
        signUpBtn.click();
    }

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.RTL")));
//    String registrationText = driver.findElement(By.cssSelector("h3.RTL")).getText();
}
