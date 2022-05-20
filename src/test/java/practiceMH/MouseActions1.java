package practiceMH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

public class MouseActions1 extends TestBase {
    /*
    1-Yeni bir class olusturalim: MouseActions1
    2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3-Cizili alan uzerinde sag click yapalim
    4-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    5-Tamam diyerek alert’i kapatalim
    6-Elemental Selenium linkine tiklayalim
    7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    */

    @Test
    public void test01() {
        //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3-Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();

        //4-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String exceptedAlertText = "You selected a context menu";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(exceptedAlertText, actualAlertText);

        //5-Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6-Elemental Selenium linkine tiklayalim
        String firstPageWindowHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowHandleSeti = driver.getWindowHandles();
        String secondPageWindowHandle = windowHandleSeti.
                stream().
                filter(t->!t.
                        equals(firstPageWindowHandle)).
                collect(Collectors.toList()).
                get(0);
        driver.switchTo().window(secondPageWindowHandle);

        String exceptedH1Text = "Elemental Selenium";
        String actualH1Text = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(exceptedH1Text, actualH1Text);
    }
}
