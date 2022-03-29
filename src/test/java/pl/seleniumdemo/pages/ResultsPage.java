package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage {

    @FindBy (css = "h4.list_title")
    private List<WebElement> hotelList;

    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public List<String> getHotelNames() {
        return hotelList.stream()
                .map(el -> el.getAttribute("textContent"))
                .toList();
    }
}
