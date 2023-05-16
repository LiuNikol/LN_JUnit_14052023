package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By school=By.xpath("//li[contains(@class,\"site-nav-menu_item\")]/button[@data-dropdown-trigger=\"aboutSchool\"]"),
            schoolDownMenu=By.xpath("//li[contains(@class,\"site-nav-menu_item\")]//ul[@data-dropdown-menu=\"aboutSchool\"]//li");
    public List<String> getListNames() {
        List<String>list = new ArrayList<>();
        driver.findElement(school).click();
        for (WebElement element : driver.findElements(schoolDownMenu)) {
            list.add(element.getText());
        }
        return list;
    }

}