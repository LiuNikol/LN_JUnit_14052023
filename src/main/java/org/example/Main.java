package org.example;


import org.openqa.selenium.By;

import static org.example.configuration.BaseClass.driver;

public class Main {
    public static void main(String[] args) {
        driver.get("https://ithillel.ua");
        driver.findElement(By.id("btn-consultation-hero")).click(); /* Знаходимо і натискаємо кнопку*/
        driver.findElement(By.id("input-name-consultation")).sendKeys("Liudmyla");/* Записуємо ім"я*/
        driver.findElement(By.id("input-email-consultation")).sendKeys("nikolaienko.l.2020@gmail.com");/* Записуємо пошту*/
        driver.findElement(By.id("input-tel-consultation")).sendKeys("979720017"); /* Записуємо телефону*/
        driver.findElement(By.cssSelector("button[data-name='tg']")).click(); /* Знаходимо і натискаємо кнопку телеграм*/
        driver.findElement(By.cssSelector("input[name='tg']")).sendKeys("https://t.me/Liu_Nik"); /* Записуємо свій нікнейм*/
        driver.findElement(By.id("listbox-btn-input-course-consultation")).click(); /* Знаходимо список -відкриваємо*/
        driver.findElement(By.cssSelector("input[placeholder='Пошук']")).sendKeys("QA Automation — Java"); /* Заповняємо поле пошуку назви курсу*/
        driver.findElement(By.xpath("//span[@class='listbox_text' and text()='QA Automation — Java']"))/* Обираємо  курсу 'QA Automation — Java'*/
                .click();
        /* Блок "Підходить будь-який час" на попапі -завжди*/
        //        driver.findElement(By.id("listbox-btn-input-consultation-consultation-time")).click(); /* якщо треба задати певний час*/
        //        driver.findElement(By.xpath("//span[@class='listbox-btn_content' and text()='Підходить будь-який час']"))
        //                .click();/* Обираємо якщо треба певний час*/

        /*обійти момент бо Блок "Підходить будь-який час" на попапі -є у певний час*/
        try {
            driver.findElement(By.id("listbox-btn-input-consultation-consultation-time")).click();/*Знаходимо і натискаємо на елемент для відкриття списку*/
            /* Перевіряємо наявність блоку з певним часом*/
            boolean isTimePresent = driver.findElements(By.xpath("//span[@class='listbox-btn_content' and text()='Підходить будь-який час']"))
                    .size() > 0;

            if (isTimePresent) {
                driver.findElement(By.xpath("//span[@class='listbox-btn_content' and text()='Підходить будь-який час']"))/*Обираємо певний час*/
                        .click();
            } else {
                // Якщо блок з певним часом відсутній, виконуємо інші дії або кидаємо виняток
                System.out.println("Блок з певним часом не знайдений");
                // Додайте необхідні дії або кидаємо виняток
            }
            /* Якщо блок з певним часом відсутній, виконуємо інші дії або кидаємо виняток*/
            driver.findElement(By.cssSelector(".checkbox_checkmark")).click();/* Знаходимо і натискаємо чекбокс згоди*/
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();/* Обробка винятку, якщо виникає помилка*/
        }
    }
}