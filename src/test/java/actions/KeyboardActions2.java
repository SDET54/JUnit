package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class KeyboardActions2 extends TestBase {
    /*
    1-Bir Class olusturalim KeyboardActions2
    2-https://html.com/tags/iframe/ sayfasina gidelim
    3-video’yu gorecek kadar asagi inin
    4-videoyu izlemek icin Play tusuna basin
    5-videoyu calistirdiginizi test edin
     */

    @Test
    public void test01() throws InterruptedException {
        //2-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3-video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //4-videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-164\"]/div/div[3]/iframe")));

        WebElement playTusu = driver.findElement(By.cssSelector(".ytp-large-play-button"));
        playTusu.click();


        //5-videoyu calistirdiginizi test edin
        WebElement video = driver.findElement(By.id("movie_player"));
        Thread.sleep(3000);
        video.click();
        WebElement gecenSureElementi = driver.findElement(By.xpath("//span[@class='ytp-time-current']"));
        Assert.assertEquals("0:02", gecenSureElementi.getText());
        System.out.println(gecenSureElementi.getText());

        //Once video calistirdim. 3 saniye beklettim ama video 2 saniye ireliledi.
        //Video'yu durdurdum.
        //Daha sonra video'da sure gosterilen yeri locate ettim ve
        //irelileme saniyesinin esitligi ile test ettim
        //En sonda gormek icin surenin text'ini yazdirdim.
        //Konsolda 0:02 saniye degerini aldim.


    }
}
