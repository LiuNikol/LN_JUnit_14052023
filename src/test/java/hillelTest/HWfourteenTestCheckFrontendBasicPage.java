package hillelTest;

import org.example.configuration.BaseClass;
import org.example.pages.HWfourteenFrontendBasicPage;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HWfourteenTestCheckFrontendBasicPage extends BaseClass {
    static HWfourteenFrontendBasicPage hwfourteenFrontendBasicPage = null;

    @BeforeClass
    // Встановлюємо URL сторінки та створюємо об'єкт HWfourteenFrontendBasicPage
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/courses/front-end-basic/");
        hwfourteenFrontendBasicPage = new HWfourteenFrontendBasicPage(driver);
    }

    @After
    // Перевіряємо поточний URL та, якщо він не відповідає очікуваному URL, переходимо на сторінку заново
    public void beforeTests() {
        if (!driver.getCurrentUrl().equals("https://dnipro.ithillel.ua/courses/front-end-basic/")) {
            driver.navigate().to("https://dnipro.ithillel.ua/courses/front-end-basic/");
        }
    }

    @Test
    // Перевіряємо, чи відповідає заголовок сторінки очікуваному значенню
    public void testGetTitle() {
        String expectedTitle = "Front-end Basic";
        assertEquals(expectedTitle, hwfourteenFrontendBasicPage.getTitle());
    }

    @Test
    // Перевіряємо, чи відповідає рейтинг курсу очікуваному значенню
    public void testGetCourseRate() {
        String expectedCourseRate = "5";
        assertEquals(expectedCourseRate, hwfourteenFrontendBasicPage.getCourseRate());
    }

    @Test
    // Перевіряємо, чи відповідає опис курсу очікуваному значенню
    public void testGetCourseDescription() {
        String expectedCourseDescription = "Розробка видимої частини будь-якого сайту називається Front-end, і це область програмування, яка розвивається швидше за інші. Жоден сучасний веб-сайт і веб-додаток не обійдуться без Front-end розробника.";

        String actualCourseDescription = hwfourteenFrontendBasicPage.getCourseDescription();
        assertEquals(expectedCourseDescription, actualCourseDescription);
    }

    @Test
    // Отримуємо список імен тренерів та виводимо їх
    public void testGetCoachNames() {
        HWfourteenFrontendBasicPage hwfourteenFrontendBasicPage = new HWfourteenFrontendBasicPage(driver);
        List<String> coachNames = hwfourteenFrontendBasicPage.getCoachNames();
        for (String coachName : coachNames) {
            System.out.println(coachName);
            // Перевіряємо, що ім'я тренера не є порожнім рядком
            assert !coachName.isEmpty();
        }
    }
}