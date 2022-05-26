package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Saucedemo extends TestBase {
    /*
    //1. "https://www.saucedemo.com" Adresine gidin
    //2. Username kutusuna "standard_user" yazdirin
    //3. Password kutusuna "secret_sauce" yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin
     */

    @Test
    public void test01() {
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        //3. Password kutusuna "secret_sauce" yazdirin

        Actions actions = new Actions(driver);
        actions.
                click(driver.findElement(By.id("user-name"))).
                sendKeys("standard_user").
                sendKeys(Keys.TAB).
                sendKeys("secret_sauce").
                perform();
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urunIsmi = driver.findElement(By.xpath("(//div[@class='inventory_item_label']/a/div)[1]"));
        String eklenecekUrunIsmi = urunIsmi.getText();
        urunIsmi.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrunBilgisi = driver.findElement(By.xpath("(//div[@class='cart_item_label']//div)[1]"));
        String sepettekiUrunIsmi = sepettekiUrunBilgisi.getText();
        Assert.assertEquals(eklenecekUrunIsmi, sepettekiUrunIsmi);

        //9. Sayfayi kapatin
        driver.close();
    }
}
