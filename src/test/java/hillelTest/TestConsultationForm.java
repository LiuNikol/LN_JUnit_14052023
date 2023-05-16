package hillelTest;

import org.example.enums.CourseName;
import org.example.configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class TestConsultationForm extends BaseClass {
    By inputNameId = By.id("input-name-consultation");

    @BeforeClass
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/");
        driver.findElement(By.id("btn-consultation-hero")).click();
    }

    @Test
    public void testNameField1() {
        WebElement inputElement = driver.findElement(inputNameId);
        inputElement.sendKeys("Liudmyla");
    }

    @Test
    public void testCourseSelected() throws InterruptedException {
        selectCourseName(CourseName.CSHARP);
    }

    private void selectCourseName(CourseName cursename) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.className("listbox-btn_content")).click();
        WebElement element = driver.findElement(By.xpath("//ul[contains(@class,\"listbox_opt-list\") and contains(@role,\"listbox\")]"));
        List<WebElement> list = element.findElements(By.tagName("li"));
        for (WebElement webElement : list) {
            if (webElement.findElement(By.tagName("span")).getText().equals(cursename.toString())) {
                webElement.findElement(By.tagName("span")).click();
            }
        }
    }
}