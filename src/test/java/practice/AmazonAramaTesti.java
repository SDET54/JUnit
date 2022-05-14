package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;


public class AmazonAramaTesti {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void close() {
        driver.close();
    }

    /*
    1. https://www.amazon.com/ sayfasina gidelim
    2. arama kutusunu locate edelim
    3. “Samsung headphones” ile arama yapalim
    4. Bulunan sonuc sayisini yazdiralim
    5. Ilk urunu tiklayalim
    6. Sayfadaki tum basliklari yazdiralim
     */

    @Test
    public void amazonTest() {
        //1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");

        //2. arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //3. “Samsung headphones” ile arama yapalim
        String aranmasiIstenenMetin = "Samsung headphones";
        searchBox.sendKeys(aranmasiIstenenMetin + Keys.ENTER);

        //4. Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisiText = driver.findElement(By.xpath("//div[@data-cel-widget='UPPER-RESULT_INFO_BAR-0']"));

        Arrays.stream(sonucSayisiText.
                        getText().
                        split("\"")).
                limit(1).
                map(t -> t.
                        split(" ")).
                forEach(t -> System.out.println(aranmasiIstenenMetin + " icin sonuc sayisi= " + t[t.length - 3]));

        //5. Ilk urunu tiklayalim
        driver.findElement(By.xpath("//img[@data-image-index='1']")).click();

        //6. Sayfadaki tum basliklari yazdiralim
        System.out.println("sayfa basligi: " + driver.getTitle());
    }
}

