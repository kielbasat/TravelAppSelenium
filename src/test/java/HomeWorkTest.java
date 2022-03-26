import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class HomeWorkTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        driver.get("http://www.kurs-selenium.pl/demo/");

        WebElement checkInInput = driver.findElement(By.cssSelector("input.dpd1"));
        checkInInput.click();
        checkInInput.sendKeys("26/03/2022");

        WebElement checkOutInput = driver.findElement(By.cssSelector("input.dpd2"));
        checkOutInput.click();
        checkOutInput.sendKeys("27/03/2022");

        driver.findElement(By.cssSelector("input[name='travellers']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#childPlusBtn")));
        driver.findElement(By.cssSelector("#childPlusBtn")).click();

//        driver.findElements(By.cssSelector("div.col-xs-12 .icon_set_1_icon-66"))
//                .stream()
//                .filter(WebElement::isDisplayed)
//                .findFirst()
//                .ifPresent(WebElement::click);

        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        String searchResult = driver.findElement(By.xpath("//h2[text()='No Results Found']")).getText();

        Assert.assertEquals(searchResult, "No Results Found");


    }
}