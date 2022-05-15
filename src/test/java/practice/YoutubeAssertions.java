package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeAssertions {
    //1) Bir class oluşturun: Youtube Assertions
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    //   ○titleTest => Sayfa başlığının "YouTube” oldugunu test edin
    @Test
    public void titleTest() {
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    //   ○imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
    @Test
    public void imageTest() {
        WebElement youtubeLogo = driver.findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }

    //   ○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBoxTest() {
        WebElement youtubeSearchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(youtubeSearchBox.isEnabled());
    }

    //   ○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest() {
        String wrongTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(wrongTitle, actualTitle);
    }
}
