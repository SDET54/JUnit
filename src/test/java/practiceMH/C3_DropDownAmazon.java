package practiceMH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C3_DropDownAmazon {
    /*
    ●Bir class oluşturun: C3_ DropDown Amazon
    ●https://www.amazon.com/ adresine gidin.
      -Test 1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        oldugunu test edin

      -Test 2
        1.Kategori menusunden Books secenegini secin
        2.Arama kutusuna Java yazin ve aratin
        3.Bulunan sonuc sayisini yazdirin
        4. Sonucun Java kelimesini icerdigini test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //●https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //  -Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        //    oldugunu test edin
        WebElement dDkategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dDkategori);

        List<WebElement> dDkategoriListesi = select.getOptions();
        Assert.assertTrue(dDkategoriListesi.size() == 28);
    }

    @Test
    public void test02() {
        //  -Test 2
        //    1.Kategori menusunden Books secenegini secin
        WebElement dDkategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dDkategori);

        select.selectByVisibleText("Books");

        //    2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        //    3.Bulunan sonuc sayisini yazdirin
        String aramaText = driver.findElement(By.xpath("//div[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']")).getText();
        String[] aramaTextArr = aramaText.split("\"")[0].split(" ");
        System.out.println("aranan kelime sayisi= " + aramaTextArr[aramaTextArr.length - 3]);

        //    4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(aramaText.contains("Java"));

    }

}
