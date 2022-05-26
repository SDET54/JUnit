package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class AmazonIphone13 extends TestBase {

    //Kendime not:
    //Bu testte ilk sorun test kontrolunde amazon sitesi 3 farkli sekilde goruntuleniyor ve
    //onemli olan locate-ler her birinde degise biliyor. Yine de incelemem lazim.

    static List<String> renkListesi = new ArrayList<>();
    static List<String> sizeListesi = new ArrayList<>();
    static List<String> priceListesi = new ArrayList<>();
    static List<String> stokListesi = new ArrayList<>();

    @Test
    public void test01() throws InterruptedException {
        //Notes: It may also be necessary to write code to accept the accept cookies warning.
        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        //2. Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone13 512" + Keys.ENTER);

        //3. Check that the results are listed
        List<WebElement> sonuclarListesi = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base']"));
        for (WebElement each : sonuclarListesi) {
            Assert.assertTrue(each.isDisplayed());
        }

        //4. Click iPhone13 at the top of the list
        sonuclarListesi.get(0).click();

        //5. Log the following values for each size
        //.Size information .Price .Color .Stock status
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        List<WebElement> sizeElements = driver.
                findElements(By.xpath("//li[@class='swatch-list-item-text inline-twister-swatch a-declarative desktop-configurator-dim-row-0']"));

        for (int i = 0; i < sizeElements.size(); i++) {
            sizeElements.get(i).click();

            for (int j = 0; j < 5; j++) {
                Thread.sleep(1000);
                List<WebElement> colorNameClick = driver.findElements(By.xpath("//input[@aria-labelledby]"));
                colorNameClick.get(j + 12).click();
                colorPriceStock();
                Thread.sleep(1000);
            }
        }

        for (int j = 0; j < renkListesi.size(); j++) {
            System.out.println("Iphone 13  " + sizeListesi.get(j) + "\n" +
                    renkListesi.get(j) + "  " + "Price: " + priceListesi.get(j) + " TL\n" +
                    "Stok: " + stokListesi.get(j) + "\n");
        }
    }

    private void colorPriceStock() throws InterruptedException {
        Thread.sleep(1000);
        WebElement sizeElementi = driver.findElement(By.id("inline-twister-dim-title-size_name"));
        sizeListesi.add(sizeElementi.getText());

        Thread.sleep(1000);
        WebElement colorNameElementi = driver.findElement(By.id("inline-twister-dim-title-color_name"));
        renkListesi.add(colorNameElementi.getText());

        WebElement priceElement = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]"));
        priceListesi.add(priceElement.getText());

        Thread.sleep(1000);
        WebElement stokElement = driver.findElement(By.xpath("//div[@id='availability']"));
        stokListesi.add(stokElement.getText());

        //Kendime not:
        //256 gb size icin extra islem yapilacak. Simdilik kod 512 ve 128 icin dogru calisiyor ama 256 gb icin
        //uygulamayi dusundugum methodu diger ikisi icin uygulamam gerekiyor cunki onlarda da stok bitmis ola bilir.
        //en iyi size-larla degil de ilk renklerden baslamaktir bence. Onu da denemem gerek.
    }
}