package excelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel2 {

    /*
    Yeni bir test method olusturalim readExcel2( )
-1.satirdaki 2.hucreye gidelim ve yazdiralim
-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
-2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
-Satir sayisini bulalim
-Fiziki olarak kullanilan satir sayisini bulun
-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */

    @Test
    public void readExcel2() throws IOException {

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        int satirNo = 1;
        int sutunNo = 2;
        System.out.println(hucreBilgisiGetir(satirNo - 1, sutunNo - 1));

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String hucreBilgisi = hucreBilgisiGetir(satirNo - 1, sutunNo - 1);
        System.out.println("hucreBilgisi = " + hucreBilgisi);

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        satirNo = 2;
        sutunNo = 4;
        hucreBilgisi = hucreBilgisiGetir(satirNo - 1, sutunNo - 1);

        Assert.assertEquals("Kabil", hucreBilgisi);

        //-Satir sayisini bulalim
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        int satirSayisiIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satirSayisi = " + (satirSayisiIndex + 1));

        //-Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String, String> ulkelerMap = new HashMap<>();

        for (int i = 0; i <= satirSayisiIndex; i++) {
            String keys = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() +
                    ", " + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() +
                    ", " + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(keys, value);

        }

        System.out.println("ulkelerMap.size() = " + ulkelerMap.size());

    }

    public String hucreBilgisiGetir(int satir, int sutun) throws IOException {
        String hucreBilgisi = "";
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        hucreBilgisi = workbook.
                getSheet("Sayfa1").
                getRow(satir).
                getCell(sutun).
                toString();
        return hucreBilgisi;

    }
}
