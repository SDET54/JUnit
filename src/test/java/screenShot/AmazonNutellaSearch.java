package screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AmazonNutellaSearch extends TestBase {
    /*
    Yeni bir class olusturun : AmazonNutellaSearch
1. amazon anasayfaya gidin
2. amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
3. Nutella icin arama yapin
4. sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
     */

    @Test
    public void test01() throws IOException {
        //1. amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2. amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertEquals("https://www.amazon.com/", driver.getCurrentUrl());

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String timeStr = time.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = new File("target/screenshot/Screenshot/FullPage" + timeStr + ".jpeg");
        File temp = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp, file);

        //3. Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        //4. sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        WebElement sonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucElementi.getText().contains("Nutella"));

        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));

        file = new File("target/screenshot/Screenshot/WebElement" + timeStr + ".jpeg");
        temp = ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp, file);
    }

}
