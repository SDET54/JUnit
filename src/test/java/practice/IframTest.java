package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframTest {
    /*
    ●Bir class olusturun: IframeTest
    ●https://the-internet.herokuapp.com/iframe adresine gidin.
    ●Bir metod olusturun: iframeTest
         ○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
         ○Text Box’a “Merhaba Dunya!” yazin.
         ○TextBox’in altinda bulunan “Elemental Selenium” linkinin textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin.
     */

    @Test
    public void iframeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/iframe");

        //○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement headText = driver.findElement(By.tagName("h3"));
        System.out.println(headText.getText());
        Assert.assertTrue(headText.isEnabled());

        //○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkinin textinin gorunur oldugunu
        //  dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();

        WebElement footText = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(footText.isDisplayed());
        System.out.println(footText.getText());

        driver.close();
    }
}
