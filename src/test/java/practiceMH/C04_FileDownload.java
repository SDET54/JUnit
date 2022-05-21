package practiceMH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    2. metodun icinde aşağıdaki testi yapalim
       -https://the-internet.herokuapp.com/download adresine gidelim
       -code.txt dosyasını indirelim
    3. dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test
    public void test01() throws InterruptedException {
        // metodun icinde aşağıdaki testi yapalim
        //    -https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //    -Text.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='text1.txt']")).click();

        Thread.sleep(5000);

        // 4. dosyanın başarıyla indirilip indirilmediğini test edelim
        String myFileHomePath = System.getProperty("user.home");
        String filesPathWillAdd = "\\Downloads\\text1.txt";
        String downloadFilesPath = myFileHomePath + filesPathWillAdd;
        Assert.assertTrue(Files.exists(Paths.get(downloadFilesPath)));
    }

}



