package practiceMH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

public class WindowHandles {
    //●Tests package’inda yeni bir class olusturun: WindowHandles
    //●https://the-internet.herokuapp.com/windows adresine gidin.
    //●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //●Click Here butonuna basın.
    //●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //●Sayfadaki textin “New Window” olduğunu doğrulayın.
    //●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    // doğrulayın.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        //●https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText, actualText);

        //●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //●Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        //1.yol
        String ikinciSayfaWindowHandle = "";
        for (String each : windowHandles) {
            if (!each.equals(ilkSayfaWindowHandle)) {
                ikinciSayfaWindowHandle = each;
            }
        }
        //2.yol lambda
        String ikinciSayfaWindowHandleLambda = windowHandles.
                stream().
                filter(t->!t.equals(ilkSayfaWindowHandle)).
                collect(Collectors.toList()).get(0);
        System.out.println("ikinciSayfaWindowHandle: " + ikinciSayfaWindowHandle);
        System.out.println("ikinciSayfaWindowHandleLambda: " + ikinciSayfaWindowHandleLambda);

        driver.switchTo().window(ikinciSayfaWindowHandle);

        //●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String newWindowExceptedTitle = "New Window";
        String newWindowActualTitle = driver.getTitle();
        Assert.assertEquals(newWindowExceptedTitle, newWindowActualTitle);

        //●Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newWindowExceptedText = "New Window";
        String newWindowActualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(newWindowExceptedText, newWindowActualText);

        //●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        // doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }
}
