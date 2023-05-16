package hillelTest;

import org.example.configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestChoseTeacher extends BaseClass {


    @BeforeClass
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/");
        driver.findElement(By.cssSelector("[data-dropdown-trigger='coursesMenu']")).click();
        driver.findElement(By.cssSelector("[data-category='programming']")).click();
        driver.findElement(By.cssSelector("[data-value='front-end']")).click();
        driver.findElement(By.xpath("//span[@class='course-label_grade' and text()='Basic']")).click();
    }

    @Test
    public void getListNamesTeachers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".coach-card_name")));

        List<String> coachNames = new ArrayList<>();

        for (WebElement element : elements) {
            coachNames.add(element.getText());
        }

        // Вивести імена вчителів
        for (String coachName : coachNames) {
            System.out.println(coachName);
        }
    }
}