package practiceMH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnableTest {
    /*
    1. Bir class olusturun : EnableTest
    2. Bir metod olusturun : isEnabled()
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Textbox’in etkin olmadigini(enabled) dogrulayın
    5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    7. Textbox’in etkin ol dugunu (enabled)
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void isEnabledTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxElement = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxElement.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxElement));
        Assert.assertTrue(textBoxElement.isEnabled());

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu (enabled) dogrulayin.
        Assert.assertTrue(textBoxElement.isEnabled());
    }
}
