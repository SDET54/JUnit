package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardActions1 extends TestBase {
    /*
    1-Bir Class olusturalim KeyboardActions1
    2-https://www.amazon.com sayfasina gidelim
    3-Arama kutusuna actions method’larine kullanarak
      samsung A71 yazdirin ve
      Enter’a basarak arama yaptirin
    4-aramanin gerceklestigini test edin
     */

    @Test
    public void test01(){
        //2-https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3-Arama kutusuna actions method’larine kullanarak
        //  samsung A71 yazdirin ve
        //  Enter’a basarak arama yaptirin
        String aranacakKelime="samsung A71";
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.sendKeys(searchBox,aranacakKelime + Keys.ENTER).perform();

        //4-aramanin gerceklestigini test edin
        String searchResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]")).getText();
        Assert.assertTrue(searchResultText.contains(aranacakKelime));
        System.out.println("searchResultText: " + searchResultText);
    }
}
