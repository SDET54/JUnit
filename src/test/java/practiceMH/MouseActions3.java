package practiceMH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class MouseActions3 extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions3
    1-https://www.amazon.com/ adresine gidelim
    2-Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
    3-“Create a list” butonuna basalim
    4-Acilan sayfada “Your Lists” yazisi oldugunu test edelim
     */

    @Test
    public void test01() {
        //1-https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com");

        //2-Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement accountAndListsElement = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountAndListsElement).perform();

        //3-“Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        //4-Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement yourListElementi = driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourListElementi.isDisplayed());
        System.out.println(yourListElementi.getText());
    }
}
