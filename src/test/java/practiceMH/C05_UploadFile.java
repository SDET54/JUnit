package practiceMH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {

    /*
    1. Tests packagenin altina bir class oluşturun : C05_UploadFile
    2. https://the-internet.herokuapp.com/upload adresine gidelim
    3. chooseFile butonuna basalim
    4. Yuklemek istediginiz dosyayi secelim
    5. Upload butonuna basalim
    6. “File Uploaded!” textinin goruntulendigini test edelim
     */

    @Test
    public void test01() {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        WebElement chooseFileElementi = driver.findElement(By.id("file-upload"));

        //4. Yuklemek istediginiz dosyayi secelim
        chooseFileElementi.sendKeys("C:\\Users\\Vaska\\Downloads\\text1.txt");

        //5. Upload butonuna basalim
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }

}
