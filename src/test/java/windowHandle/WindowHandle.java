package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandle {
    /*
    ●Yeni bir class olusturun: WindowHandle
    ●Amazon anasayfa adresine gidin.
    ●Sayfa’nin window handle degerini String bir degiskene atayin
    ●Sayfa title’nin “Amazon” icerdigini test edin
    ●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    ●Sayfa title’nin “Techpro Education” icerdigini test edin
    ●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    ●Sayfa title’nin “Walmart” icerdigini test edin
    ●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // ●Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        // ●Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonIlkWindowHandle = driver.getWindowHandle();

        // ●Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        // ●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.techproeducation.com");

        // ●Sayfa title’nin “Techpro Education” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        // ●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");

        // ●Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        // ●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonIlkWindowHandle);
    }

}
