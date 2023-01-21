package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void baslangicIslemleri(String browser) {
        System.out.println("Başlangıç işlemleri");
        //ilk adımda çalışan kod kısmı
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeServici sessiz modda çalıştır
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginTest();
    }

    void loginTest() {
        driver.get("https://admin-demo.nopcommerce.com/login");

        System.out.println("login test");
        WebElement inputEmail = driver.findElement(By.cssSelector("#Email"));
        inputEmail.clear();
        inputEmail.sendKeys("admin@yourstore.com");

        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.clear();
        password.sendKeys("admin");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

//        WebElement loginText= driver.findElement(By.cssSelector("div[class='col-12'] h4"));
        String mainHeading= driver.getTitle();
        System.out.println("mainHeading = " + mainHeading);



    }

    @AfterClass(enabled = true)
    public void bitisIslemleri() {
        System.out.println("bitiş işlemleri");
        Tools.wait(3);
        driver.quit();
    }

}