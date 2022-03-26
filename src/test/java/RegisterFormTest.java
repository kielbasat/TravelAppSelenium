
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

public class RegisterFormTest {

    @Test
    public void searchHotel() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/register");

        String lastname = "Kabanos";

        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Tomek");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys(lastname);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("888761637");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys( Math.random() + "@test.test");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("#DupaCycki");
        driver.findElement(By.cssSelector("input[name=confirmpassword]")).sendKeys("#DupaCycki");
        driver.findElement(By.cssSelector(".signupbtn")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.RTL")));
        String registrationText = driver.findElement(By.cssSelector("h3.RTL")).getText();

        Assert.assertEquals(registrationText, "Hi, Tomek Kabanos");
        Assert.assertTrue(registrationText.contains(lastname));



    }

}