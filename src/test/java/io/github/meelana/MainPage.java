package io.github.meelana;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class  MainPage {
     public void open() {
        Selenide.open("/");
    }

    public void search(String text) {
        SelenideElement input =  $(By.id("searchInput"));
        input.click();
        input.sendKeys(text);
    }
    public void search2(String text) {
        SelenideElement input = $(By.id("searchInput"));
        input.click();
        //   здесь не работал тест номер 4
        // Когда в поле поиска вводило "Genshin Impact" то, почему-то не показывалась ссылка  "Поиск страниц содержащих Genshin Impact"  хотя в обычном браузере всё работало
        //  Скорее всего оно всё делало слишком быстро и нужна какая-то задержка, например ввести строку не сразу  а по частям
            input.clear();
            input.sendKeys( text.substring(0,1));
            input.sendKeys( text.substring(1));
    }

    public void buttonClick() {
        // нажать лупу
         $(By.id("searchButton")).click();
    }

    public ElementsCollection results() {
         return $$(".suggestions-results .mw-searchSuggest-link");
    }

     public SelenideElement linkGoAllResults() {
            return $(".suggestions > .mw-searchSuggest-link");
    }

}