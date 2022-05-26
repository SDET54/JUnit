package practiceMH;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class D19_WebTablesHomeWork extends TestBase {
    /*
    Bir Class olusturun D19_WebTablesHomeWork
1. https://demoqa.com/webtables” sayfasina gidin
2. Headers da bulunan department isimlerini yazdirin
3. Sutunlarin basligini yazdirin
4. Tablodaki tum datalari yazdirin
5. Tabloda kac cell (data) oldugunu yazdirin
6. Tablodaki satir sayisini yazdirin
7. Tablodaki sutun sayisini yazdirin
8. Tablodaki 3.kolonu yazdirin
9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
girdigimde bana datayi yazdirsin
     */

    @Test
    public void test01() {
        //1. https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan Department isimlerini yazdirin
        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//div[@class='rt-thead -header']/div/div"));

        System.out.println("\n========================================================\n");
        int departmentSutunNo = 1;
        for (int i = 0; i < sutunBasliklari.size(); i++) {
            if (sutunBasliklari.get(i).getText().equals("Department")) {
                departmentSutunNo = i;
            }
        }
        List<WebElement> departmentElemantlari = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[" + (departmentSutunNo + 1) + "]"));
       departmentElemantlari.
               stream().
               filter(t->!(t.getText().equals(" "))).
               forEach(t-> System.out.println(t.getText()));

        System.out.println("\n========================================================\n");
        //3. sutunlarin basligini yazdirin
        for (WebElement each : sutunBasliklari) {
            System.out.print(each.getText() + " ");
        }

        //4. Tablodaki tum datalari yazdirin
        WebElement tumDataElement = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("\n========================================================\n");
        System.out.println(tumDataElement.getText());

        //5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> tumCellElement = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div"));
        System.out.println("\n========================================================\n");
        System.out.println("Tabloda " + tumCellElement.size() + " adet cell var.");

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElement = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("\n========================================================\n");
        System.out.println("Tabloda " + satirElement.size() + " adet satir var.");

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("\n========================================================\n");
        System.out.println("Tabloda " + sutunBasliklari.size() + " adet sutun var.");

        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("\n========================================================\n");
        int kolon = 3;
        List<WebElement> kolonElement = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[" + kolon + "]"));
        for (int i = 0; i < 3; i++) {
            System.out.print(kolonElement.get(i).getText() + " ");
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        int firstNameSutunNo = 1;
        int salarySutunNo = 1;

        for (int i = 0; i < sutunBasliklari.size(); i++) {
            if (sutunBasliklari.get(i).getText().equals("First Name")) {
                firstNameSutunNo = i;
            }
        }

        int kierraSatirNo = 1;
        List<WebElement> firstNameElemanlari = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[" + (firstNameSutunNo + 1) + "]"));
        for (int i = 0; i < firstNameElemanlari.size(); i++) {
            if (firstNameElemanlari.get(i).getText().equals("Kierra")) {
                kierraSatirNo = i;
            }
        }

        for (int i = 0; i < sutunBasliklari.size(); i++) {
            if (sutunBasliklari.get(i).getText().equals("Salary")) {
                salarySutunNo = i;
            }
        }
        System.out.println("\n========================================================\n");
        System.out.println("Kierra salary= " + driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + (kierraSatirNo + 1) + "]//div[" + (salarySutunNo + 1) + "]")).getText());


        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        //girdigimde bana datayi yazdirsin

        int satir = 3;
        int sutun = 5;

        hucreBilgisi(satir, sutun);

    }

    private void hucreBilgisi(int satir, int sutun) {
        WebElement hucreElement = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + satir + "]//div[" + sutun + "]"));
        System.out.println(satir + ".satir, " + sutun + ".sutun: " + hucreElement.getText());

    }

}
