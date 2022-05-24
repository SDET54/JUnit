package practiceEH;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q08_ExplicitlyWait {


/*
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
    //click on action dialog button
    //if need use explicitly wait
    //click on the ok button
    //accept the alert message
 */

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");

        //maximize the window
        driver.manage().window().maximize();

        //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();

        //if need use explicitly wait
        //click on the ok button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog-mycodemyway-action"))).click();

        //accept the alert message
        driver.switchTo().alert().accept();

        driver.close();

    }


}


