package hillelTest;

import org.example.configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.example.pages.MainPage;

public class TestHillel extends BaseClass {
    static MainPage mainPage;
    @BeforeClass
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/");
        mainPage=new MainPage(driver);
    }
    @Test
    public void testik(){
        System.out.println(mainPage.getListNames());
    }
}