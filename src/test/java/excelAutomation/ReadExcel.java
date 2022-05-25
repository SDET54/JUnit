package excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    /*
    1. apache poi dependency’i pom file’a ekleyelim
    2. src klasoru altinda resources klasoru olusturalim
    3. Excel dosyamizi resources klasorune ekleyelim
    4. excelAutomation isminde bir package olusturalim
    5. ReadExcel isminde bir class olusturalim
    6. readExcel() method olusturalim
    7. Dosya yolunu bir String degiskene atayalim
    8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    10. WorkbookFactory.create(fileInputStream)
    11. Worksheet objesi olusturun workbook.getSheetAt(index)
    12. Row objesi olusturun sheet.getRow(index)
    13. Cell objesi olusturun row.getCell(index)
     */

    @Test
    public void readExcel() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        // 11. Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        // 12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);

        // 13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        //Kisasi:
        String hucreBilgisi = workbook.
                getSheet("Sayfa1").
                getRow(3).
                getCell(3).
                toString();

        //denemek icin
        System.out.println("cell = " + cell);
        System.out.println("hucreBilgisi = " + hucreBilgisi);

    }




}
