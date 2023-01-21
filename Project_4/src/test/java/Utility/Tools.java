package Utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tools {

    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void messageValidation(){
        WebElement succsMsg=BaseDriver.driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(succsMsg.getText().toLowerCase().contains("success"));
    }

    public static int RandomGenerator(int max)
    {
        return  (int)(Math.random() * max);  //max 4 =>  0 1 2 3
    }

    public static void listContainsString(List<WebElement> list, String aranacakKelime) {
        boolean bulundu = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(aranacakKelime)) {
                bulundu = true;
                break;
            }
        }
        if (!bulundu)
            Assert.fail("Aranan text bulunamadı");
    }


    public static int RandomNumberGenerator(int max)  // size dan 4 geldiğinde 0,1,2,3 verir
        {
            return (int)(Math.random()* max);  // 0-max dahil

            // Random rnd=new Random();
            // return random.NextInt(max-1)+1;

        }

}
