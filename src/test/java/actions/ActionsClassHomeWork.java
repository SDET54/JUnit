package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsClassHomeWork extends TestBase {
    /*
    Yeni Class olusturun ActionsClassHomeWork
    1-"http://webdriveruniversity.com/Actions" sayfasina gidin
    2-Hover over Me First" kutusunun ustune gelin
    3-Link 1" e tiklayin
    4-Popup mesajini yazdirin
    5-Popup'i tamam diyerek kapatin
    6-“Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin
    8-“Double click me" butonunu cift tiklayin
     */

    @Test
    public void test01(){
        //1-"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2-Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirstElementi = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        actions.moveToElement(hoverOverMeFirstElementi).perform();

        //3-Link 1" e tiklayin
        driver.findElement(By.xpath("//a[@class='list-alert'][1]")).click();

        //4-Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6-“Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElementi = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHoldElementi).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement afterClickAndHoldElementi = driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(afterClickAndHoldElementi.getText());

        //8-“Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickMe);

    }
}
