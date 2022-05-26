package assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonAssertions {
    //1) Bir class oluşturun: Amazon Assertions

    WebDriver driver;

    //2) https://www.amazon.com/ A dresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void amazonAssertions() {
        driver.get("https://www.amazon.com");

        //     ○Sayfa URL’inin https://www.amazon.com/‘a esit oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        //     ○titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String pageTitleAranilacakKelime = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(pageTitleAranilacakKelime));

        //     ○logoTest => Amazon logosunun görüntülendigini test edin
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());

        //     ○FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        //     *fransizca yok

    }
}
