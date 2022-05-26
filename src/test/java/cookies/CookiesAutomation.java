package cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class CookiesAutomation extends TestBase {
    /*
    Yeni bir class olusturun : CookiesAutomation
1. Amazon anasayfaya gidin
2. tum cookie’leri listeleyin
3. Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4. ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5. ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
   olusturun ve sayfaya ekleyin
6. eklediginiz cookie’nin sayfaya eklendigini test edin
7. ismi skin olan cookie’yi silin ve silindigini test edin
8. tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void test01() {
        //1. Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2. tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            System.out.println(each);
        }

        //3. Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size() > 5);

        //4. ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookieSet) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        //5. ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //   olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cikolata", "cikolatali");

        driver.manage().addCookie(cookie);

        //6. eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            if (each.getName().equals("en sevdigim cookie")) {
                Assert.assertEquals("cikolatali", each.getValue());
            }
        }

        //7. ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            Assert.assertNotEquals("skin", each.getName());
        }


        //8. tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertEquals(0, cookieSet.size());
    }
}
