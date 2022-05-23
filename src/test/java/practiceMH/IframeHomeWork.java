package practiceMH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeHomeWork extends TestBase {
    /*
    Iframe Home Work
1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
2. “Our Products” butonuna basin
3. “Cameras product”i tiklayin
4. Popup mesajini yazdirin
5. “close” butonuna basin
6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */

    @Test
    public void test01() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='../Page-Object-Model/index.html']")));
        driver.findElement(By.linkText("Our Products")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        //4. Popup mesajini yazdirin
        Thread.sleep(3000);
        WebElement popElementi = driver.findElement(By.className("modal-content"));
        System.out.println(popElementi.getText());

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

    }
}
