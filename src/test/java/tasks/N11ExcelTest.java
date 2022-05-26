package tasks;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class N11ExcelTest extends TestBase {
    /*
1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör” seçilir.
2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya txt dosyasına yazdırılır.
     */

    @Test
    public void test01() throws IOException {
        driver.get("https://www.n11.com");

        driver.findElement(By.xpath("(//div[@class='content']/span)[2]")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='hBotMenu']/nav//li[5]"))).perform();
        driver.findElement(By.xpath("//div[@class='hOpenMenu']//a[1]")).click();

        driver.findElement(By.xpath("//h3[text()='Tüm Mağazalar']")).click();

        List<WebElement> aHarfliMagazalarList = driver.findElements(By.xpath("//div[@class='tabPanel allSellers']//div[2]/ul/li"));
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.createSheet("N11").
                createRow(0).
                createCell(0).
                setCellValue("Mağazalar");

        for (int i = 0; i < aHarfliMagazalarList.size(); i++) {

            workbook.
                    getSheet("N11").
                    createRow(i + 1).
                    createCell(0).
                    setCellValue((aHarfliMagazalarList.get(i).getText()));
        }

        FileOutputStream fos = new FileOutputStream("src/resources/ulkeler.xlsx");
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();
    }

}

