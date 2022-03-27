import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.seleniumdemo.tests.BaseTest;

public class SignUpTest extends BaseTest {

    @Test
    public void searchHotelTest() {


        driver.get("http://www.kurs-selenium.pl/demo/");

        driver.findElements(By.cssSelector("#li_myaccount"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElements(By.xpath("//a[text()='  Sign Up']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

    }

}
