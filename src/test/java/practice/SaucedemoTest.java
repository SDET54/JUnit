package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SaucedemoTest {
    /*
    1. “https://www.saucedemo.com” Adresine gidin
    2. Username kutusuna “standard_user” yazdirin
    3. Password kutusuna “secret_sauce” yazdirin
    4. Login tusuna basin
    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6. Add to Cart butonuna basin
    7. Alisveris sepetine tiklayin
    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9. Sayfayi kapatin
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void saucedemoTest() {
        //    1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //    2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //    3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //    4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        List<WebElement> urunIsimleri = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        String ilkUrunIsmi = urunIsimleri.get(0).getText();
        urunIsimleri.get(0).click();

        //    6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[.='Add to cart']")).click();

        //    7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepettekiUrunIsmi = driver.findElement(By.xpath("//div[@class='cart_item']//div/a/div")).getText();
        if (ilkUrunIsmi.equals(sepettekiUrunIsmi)) {
            System.out.println("urun sepete ekleme testi PASSED");
        }else System.out.println("urun sepete ekleme testi FAILED");

        //    9. Sayfayi kapatin.
        //       ok
    }
}
