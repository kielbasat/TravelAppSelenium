import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HotelSearchTest {

    @Test
    public void searchHotel() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");

        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.cssSelector("div#select2-drop input.select2-input")).sendKeys("Dubai");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.select2-match"))).click();

        driver.findElement(By.cssSelector("input.dpd1")).sendKeys("25/03/2022");
        driver.findElement(By.cssSelector("input.dpd2")).click();
        driver.findElements(By.cssSelector("body > div:nth-child(15) > div.datepicker-days > table > tbody > " +
                        "tr:nth-child(5) > td:nth-child(5)"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElement(By.cssSelector("#travellersInput")).click();

        WebDriverWait waitPerson = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitPerson.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#adultMinusBtn .fa-minus"))).click();
        driver.findElement(By.cssSelector("button#childPlusBtn")).click();

        driver.findElement(By.xpath("//button[text()=' Search']")).click();

//        WebDriverWait waitHotelList = new WebDriverWait(driver, Duration.ofSeconds(5));
//        waitHotelList.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.list_title")));

        List<String> hotelNames = driver.findElements(By.cssSelector("h4.list_title"))
                .stream()
                .map(el -> el.getAttribute("textContent"))
                .toList();

        Assert.assertEquals(hotelNames.get(0),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1),"Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3),"Hyatt Regency Perth");
    }

}
