
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeWork2Test {

    @Test
    public void searchHotelNoData() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/register");

        String lastname = "Kabanos";
        String invalidEmail = "Selenium.pl";

        driver.findElement(By.cssSelector("input[name=firstname]"));
        driver.findElement(By.cssSelector("input[name=lastname]"));
        driver.findElement(By.cssSelector("input[name=phone]"));
        driver.findElement(By.cssSelector("input[name=email]"));
        driver.findElement(By.cssSelector("input[name=password]"));
        driver.findElement(By.cssSelector("input[name=confirmpassword]"));
        driver.findElement(By.cssSelector(".signupbtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-danger p")));

        List<String> alertTextList = driver.findElements(By.cssSelector("div.alert-danger p"))
                .stream()
                .map(WebElement::getText)
                .toList();

        SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(alertTextList.contains("The Email field is required."));
                softAssert.assertTrue(alertTextList.contains("The Password field is required."));
                softAssert.assertTrue(alertTextList.contains("The Password field is required."));
                softAssert.assertTrue(alertTextList.contains("The First name field is required."));
                softAssert.assertTrue(alertTextList.contains("The Last Name field is required."));
                softAssert.assertAll();

//        Assert.assertEquals(alertTextList.get(0), "The Email field is required.");
//        Assert.assertEquals(alertTextList.get(1), "The Password field is required.");
//        Assert.assertEquals(alertTextList.get(2), "The Password field is required.");
//        Assert.assertEquals(alertTextList.get(3), "The First name field is required.");
//        Assert.assertEquals(alertTextList.get(4), "The Last Name field is required.");


    }

    @Test
    public void searchHotelInvalidEmail() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/register");

        String lastname = "Kabanos";
        String invalidEmail = "Selenium.pl";

        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Tomek");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys(lastname);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("888761637");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys( invalidEmail);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("#DupaCycki");
        driver.findElement(By.cssSelector("input[name=confirmpassword]")).sendKeys("#DupaCycki");
        driver.findElement(By.cssSelector(".signupbtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-danger p")));

        List<String> alertTextList = driver.findElements(By.cssSelector("div.alert-danger p"))
                .stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertEquals(alertTextList.get(0), "The Email field must contain a valid email address.");

    }

}
