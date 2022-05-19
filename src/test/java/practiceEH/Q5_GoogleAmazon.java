package practiceEH;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5_GoogleAmazon {

    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim

       */

    static WebDriver driver;

    //@BeforeClass ın icerisinde driver i kuralim
    //maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
    @Test
    public void test01() {
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    //Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        if (driver.getCurrentUrl().contains("www.amazon.com")) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");
    }

    //@AfterClass ta driver ı kapatalim
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}
