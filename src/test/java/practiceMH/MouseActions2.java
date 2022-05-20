package practiceMH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class MouseActions2 extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions2
    1-https://demoqa.com/droppable adresine gidelim
    2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test01(){
        //1-https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElement = driver.findElement(By.id("draggable"));
        WebElement dropHereElement = driver.findElement(By.xpath("//div[@id='droppable'][1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();

        //3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String exceptedTextAfterDragDrop = "Dropped!";
        String actualTextAfterDragDrop = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assert.assertEquals(exceptedTextAfterDragDrop,actualTextAfterDragDrop);

    }
}
