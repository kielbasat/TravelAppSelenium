import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pl.seleniumdemo.tests.BaseTest;

import java.time.Duration;

public class CityHotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        driver.get("http://www.kurs-selenium.pl/demo/");

        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.cssSelector("div#select2-drop input.select2-input")).sendKeys("Dubai");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.select2-match")));
        driver.findElement(By.cssSelector("span.select2-match")).click();

        driver.findElement(By.cssSelector("input.dpd1")).sendKeys("17/04/2022");
        driver.findElement(By.cssSelector("input.dpd2")).sendKeys("17/05/2022");
    }
}
