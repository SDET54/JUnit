package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
    ...Exercise1...
    BeforeClass ile driver'ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın
 */

    static WebDriver driver;

    // BeforeClass ile driver ı olusturun ve class icinde static yapin
    // Maximize edin, 15 sn bekletin
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void testOncesi() {
        // http://www.google.com adresine gidin
        driver.get("https://www.google.com");
    }

    @After
    public void testSonrasi() {
        WebElement filmSonucSayisi = driver.findElement(By.cssSelector("div[id='result-stats']"));
        System.out.println("filmSonucSayisi = " + filmSonucSayisi.getText());
    }

    // AfterClass ile kapatın
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    // arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile" + Keys.ENTER);
    }

    // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition" + Keys.ENTER);
    }

    // arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
    }

}

