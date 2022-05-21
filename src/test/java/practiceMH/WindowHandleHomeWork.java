package practiceMH;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

public class WindowHandleHomeWork extends TestBase {
    /*
    Window Handle HomeWork
1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
     */

    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firsPageUrl = driver.getCurrentUrl();

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        //3."Login Portal" a tiklayin
        String firstPageWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        //4.Diger window'a gecin
        Set<String> allWindowHandle = driver.getWindowHandles();
        String seconPageWindowHandle = allWindowHandle.
                stream().
                filter(t -> !t.
                        equals(firstPageWindowHandle)).
                collect(Collectors.
                        toList()).
                get(0);

        driver.switchTo().window(seconPageWindowHandle);

        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        Faker faker = new Faker();
        WebElement usernameElement = driver.findElement(By.id("text"));
        actions.
                click(usernameElement).
                sendKeys(faker.name().username()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String exceptedPopText = "validation failed";
        String actualPopText = driver.switchTo().alert().getText();

        Assert.assertEquals(exceptedPopText, actualPopText);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstPageWindowHandle);

        //10.Ilk sayfaya donuldugunu test edin
        String firstPageUrlAfterSwitch = driver.getCurrentUrl();
        Assert.assertEquals(firsPageUrl, firstPageUrlAfterSwitch);
    }
}
