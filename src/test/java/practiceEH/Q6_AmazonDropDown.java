package practiceEH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q6_AmazonDropDown {
    /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");

        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement amazonDdM = driver.findElement(By.id("searchDropdownBox"));
        Select selectAmazonDdM = new Select(amazonDdM);
        selectAmazonDdM.selectByVisibleText("Books");

        //    kategorilerin hepsini konsola yazdiralim
        List<WebElement> amazonDdMoptions = selectAmazonDdM.getOptions();
        for (WebElement each : amazonDdMoptions) {
            System.out.println(each.getText());
        }

        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        String aranacakKelime = "Les Miserables";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(aranacakKelime + Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim.
        WebElement sonucTablo = driver.findElement(By.xpath("//div[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']"));
        String[] aramaSonucuText = sonucTablo.getText().split("\"")[0].split(" ");
        String aramaSonucuSayisi = aramaSonucuText[aramaSonucuText.length - 3];
        System.out.println(aranacakKelime + " icin sonuc sayisi: " + aramaSonucuSayisi);

        // 5. Sonucların Les Miserables'i icerdigini assert edelim
        Assert.assertTrue(sonucTablo.getText().contains(aranacakKelime));

        driver.close();


    }


}