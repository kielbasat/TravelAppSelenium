package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h3.RTL")
    private WebElement headingText;

    public String getHeadingText() {
        return headingText.getText();
    }
}
