package org.example.pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HWfourteenFrontendBasicPage {
    private final String becomeSelector = "//button[@data-modal=\"become-coach\"]";
    private WebDriver driver;
    private WebDriverWait wait;
    private static WebDriver driverInHWfourteenFrontendBasicPage;

    @FindBy(xpath = "//strong[text()='Front-end Basic']")
    private WebElement courseTitleElement;

    @FindBy(xpath = "//span[@class='course-rating_average']")
    private WebElement courseRatingAverage;

    @FindBy(xpath = "//p[contains(text(),'Розробка видимої частини будь-якого сайту називається Front-end, і це область програмування, яка розвивається швидше за інші. Жоден сучасний веб-сайт і веб-додаток не обійдуться без Front-end розробника.')]")
    private WebElement courseDescriptionElement;

    public WebElement getCourseDescriptionElement() {
        return courseDescriptionElement;
    }

    @FindBy(css = ".coach-list.coaches_list")
    private WebElement listCoachesNames;




    public HWfourteenFrontendBasicPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public String getTitle() {
        return courseTitleElement.getText();
    }


    public String getCourseRate() {
        return courseRatingAverage.getText();
    }


    public String getCourseDescription() {
        // Отримує опис курсу та перевіряє, чи він відображається на сторінці
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 800)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getCourseDescriptionElement()));
        wait.until(ExpectedConditions.textToBePresentInElement(getCourseDescriptionElement(), "Розробка видимої частини будь-якого сайту називається Front-end"));

        return getCourseDescriptionElement().getText();
    }


    public List<String> getCoachNames() {
        // Отримує список імен тренерів
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 2600)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(listCoachesNames));

        String html = driver.getPageSource();
        Document document = Jsoup.parse(html);
        Elements coachCards = document.select(".coaches .coach-card_name");
        List<String> coachNames = new ArrayList<>();
        for (Element coachCard : coachCards) {
            coachNames.add(coachCard.text());
        }
        return coachNames;
    }
}