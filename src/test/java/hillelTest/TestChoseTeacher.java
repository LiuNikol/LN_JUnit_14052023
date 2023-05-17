package hillelTest;

import org.example.configuration.BaseClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class TestChoseTeacher extends BaseClass {


    @BeforeClass
    public static void startSite() throws InterruptedException {
        driver.get("https://dnipro.ithillel.ua/");
        driver.findElement(By.cssSelector("[data-dropdown-trigger='coursesMenu']")).click();
        driver.findElement(By.cssSelector("[data-category='programming']")).click();
        driver.findElement(By.cssSelector("[data-value='front-end']")).click();
        driver.findElement(By.xpath("//span[@class='course-label_grade' and text()='Basic']")).click();
        /* Затримка, щоб дати сторінці завантажитися*/
        Thread.sleep(2000);

        /* Прокрутка сторінки вниз по 2600 мм*/
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2600)");

        /* Затримка, щоб дати сторінці прогрузитися*/
        Thread.sleep(3000);

        WebElement element3 = driver.findElement(By.cssSelector(".coach-list.coaches_list"));
        element3.click();
    }

    @Test
    public void ListT() {

        String html = driver.getPageSource();       /*Отримує джерело сторінки*/

        Document document = Jsoup.parse(html);      /*Застосовує Jsoup для розбору HTML-коду сторінки і створює об'єкт Document*/
        Elements coachCards = document.select(".coaches .coach-card_name");     /*Виконує пошук елементів, відповідних селектору ".coaches .coach-card_name",*/
        List<String> coachNames = new ArrayList<>();
        for (Element coachCard : coachCards) {      /*Додає текст кожного знайденого елемента coachCard до списку*/
            coachNames.add(coachCard.text());       /*Виводить кожне ім'я тренера зі списку */
        }

        for (String coachName : coachNames) {
            System.out.println(coachName);
        }
    }
}


//package hillelTest;
//
//        import org.example.configuration.BaseClass;
//        import org.jsoup.Jsoup;
//        import org.jsoup.nodes.Document;
//        import org.jsoup.nodes.Element;
//        import org.jsoup.select.Elements;
//        import org.junit.BeforeClass;
//        import org.junit.Test;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.support.ui.ExpectedConditions;
//        import org.openqa.selenium.support.ui.WebDriverWait;
//
//        import java.time.Duration;
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.NoSuchElementException;
//
//public class TestButtonProgramming extends BaseClass {
//
//    @BeforeClass
//    public static void startSite() throws NoSuchElementException {
//        driver.get("https://dnipro.ithillel.ua/");
//        WebElement element1 = driver.findElement(By.xpath("//p[@class='course-cat-bar_label' and text()='Програмування']"));
//        element1.click();
//        WebElement element2 = driver.findElement(By.xpath("//p[@class='profession-bar_title' and text()='Front-end Basic']"));
//        element2.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".coach-list.coaches_list")));
//        element3.click();
//
//    }
//
//    @Test
//    public void ListT() {
//        String html = driver.getPageSource();/*Отримує джерело сторінки*/
//
//        Document document = Jsoup.parse(html);/*Застосовує Jsoup для розбору HTML-коду сторінки і створює об'єкт Document*/
//        Elements coachCards = document.select(".coaches .coach-card_name");/*Виконує пошук елементів, відповідних селектору ".coaches .coach-card_name",*/
//        List<String> coachNames = new ArrayList<>();
//        for (Element coachCard : coachCards) {/*Додає текст кожного знайденого елемента coachCard до списку*/
//            coachNames.add(coachCard.text());/*Виводить кожне ім'я тренера зі списку */
//        }
//
//        for (String coachName : coachNames) {
//            System.out.println(coachName);
//        }
//    }
//}