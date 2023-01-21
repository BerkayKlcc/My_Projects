package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver; // Bunu `extends` yaparak cagiririz

    // public static void startDriver
    static { // Sadece static yaparsak bu default olarak baslayacak


        // Selenium loglarini temizlemek icin
        Logger Log= Logger.getLogger(""); // Butun Loglara ulastik
        Log.setLevel(Level.SEVERE); // Sadece errorlari gosterir

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Selenium bildirimlerini sessize alir
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().window().maximize(); // Ekrani buyutur
        driver.manage().deleteAllCookies(); // Sitenin topladigi coockiesleri siler/ Cunku sistem bizi robot olarak isaretliyor

        Duration dr=Duration.ofSeconds(30); // Duration zaman araligi demek
        driver.manage().timeouts().pageLoadTimeout(dr);// Sayfanin tamaminin yuklenmesini bekler
        // Belirtilen sure kadar selenium bekler yuklenmezse hata verir/ Sonsuz beklemeyi engeller
        // Max 30 sn bekler daha erken yuklerse isleme baslar

        driver.manage().timeouts().implicitlyWait(dr);  // Butun web elementlerin yuklenmesini bekleyecegi max suredir

    }
    public static void driverActiklariniKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    public static void stopDriver(){
        MyFunc.wait(3);
        driver.quit();
    }
}
