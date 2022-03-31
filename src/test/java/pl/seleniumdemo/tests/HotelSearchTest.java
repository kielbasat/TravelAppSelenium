package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.time.Duration;
import java.util.List;

public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        List<String> hotelNames = hotelSearchPage.setCity("Dubai")
                        .setDate("27/03/2022", "29/03/2022")
                        .setTravellers(1, 1)
                        .performSearch()
                        .getHotelNames();

        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
    }

    @Test
    public void searchHotelWithoutNameTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        ResultsPage resultsPage = new HotelSearchPage(driver)
                .setDate("27/03/2022", "29/03/2022")
                .setTravellers(1, 1)
                .performSearch();

        Assert.assertEquals(resultsPage.hotelSearchResults(), "No Results Found");
    }
}
