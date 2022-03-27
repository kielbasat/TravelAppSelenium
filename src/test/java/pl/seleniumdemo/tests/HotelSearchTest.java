package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;

import java.time.Duration;
import java.util.List;

public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDate("27/03/2022", "29/03/2022");
        hotelSearchPage.setTravellers();
        hotelSearchPage.performSearch();

        List<String> hotelNames = driver.findElements(By.cssSelector("h4.list_title"))
                .stream()
                .map(el -> el.getAttribute("textContent"))
                .toList();
//
//        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
//        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
//        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
//        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
    }
}
