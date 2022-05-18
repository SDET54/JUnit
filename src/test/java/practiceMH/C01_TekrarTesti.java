package practiceMH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    /*
    1. C01_TekrarTesti isimli bir class olusturun
    2. https://www.google.com/ adresine gidin
    3. cookies uyarisini kabul ederek kapatin
    4. Sayfa basliginin “Google” ifadesi icerdigini test edin
    5. Arama cubuguna “Nutella” yazip aratin
    6. Bulunan sonuc sayisini yazdirin
    7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    8. Sayfayi kapatin
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
    public void googleAramaTesti() {
        //    1. C01_TekrarTesti isimli bir class olusturun
        //       olusturuldu

        //    2. https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        //    3. cookies uyarisini kabul ederek kapatin
        //       uyari cikmadi

        //    4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        String istenenTitleIfadesi = "Google";
        if (driver.getTitle().contains(istenenTitleIfadesi)) {
            System.out.println("Title test PASSED");
        } else System.out.println("Title test FAILED");

        //    5. Arama cubuguna “Nutella” yazip aratin
        String aranmasiIstenenMetin = "Nutella";
        driver.findElement(By.className("gLFyf")).sendKeys(aranmasiIstenenMetin + Keys.ENTER);

        //    6. Bulunan sonuc sayisini yazdirin
        String sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ")[1];
        System.out.println(aranmasiIstenenMetin + " bulunan sonuc sayisi= " + sonucSayisi);

        //    7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonucSayisi = sonucSayisi.replaceAll("\\D", "");
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonucSayisi) > istenenSayi);

        //if (Integer.parseInt(sonucSayisi) > istenenSayi) {
        //            System.out.println(Integer.parseInt(sonucSayisi) + " > " + istenenSayi + " test PASSED");
        //        } else System.out.println(Integer.parseInt(sonucSayisi) + " !> " + istenenSayi + " test PASSED");

        //    8. Sayfayi kapatin
        //       ok

    }
}
