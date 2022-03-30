package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSearchPage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(css = "div#select2-drop input.select2-input")
    private WebElement cityInput;

    @FindBy(css = "span.select2-match")
    private WebElement cityMatch;

    @FindBy(css = "input.dpd1")
    private WebElement checkInDateInput;

    @FindBy(css = "input.dpd2")
    private WebElement checkOutDateInput;

    @FindBy(css = "#travellersInput")
    private WebElement travellersInput;

    @FindBy(css = "#adultMinusBtn .fa-minus")
    private WebElement adultMinusBtn;

    @FindBy(css = "button#childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchBtn;


    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setCity(String cityName) {
        searchSpan.click();
        cityInput.sendKeys(cityName);
        cityMatch.click();
    }

    public void setDate(String inDate, String outDate) {
        checkInDateInput.sendKeys(inDate);
        checkOutDateInput.sendKeys(outDate);
    }

    public void setTravellers(int adultsToSubtract, int childToAdd) {
        travellersInput.click();
        addTraveler(adultMinusBtn, adultsToSubtract);
        addTraveler(childPlusBtn, childToAdd);
    }

    public void addTraveler (WebElement travelerBtn, int numberOfTravelers){
        for(int i=0; i<numberOfTravelers; i++)
            travelerBtn.click();
    }

    public void performSearch() {
        searchBtn.click();
    }
}