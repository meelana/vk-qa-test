package io.github.meelana;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class  Test4 {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl =  "https://ru.wikipedia.org";
    }


     @Test
    //  4. Снизу всегда есть подсказка: "Поиск страниц содержащих", при клике на нее выполняется переход на страницу поиска.
    public void test4Found() {
        MainPage main = new MainPage();
         main.open();
        //  При вводе поискового запроса
        //   Здесь не появлялась ссылка Все запросы содержащие Genshin Impact, пришлось вводить текст не сразу а частями
        main.search2( "Genshin Impact");
        // при клике на нее выполняется переход на страницу поиска.
        main.linkGoAllResults().click();
        //  переходим на первую подсказку саджеста, если он был.
         SearchResultsPage page = new SearchResultsPage();
            page.title().shouldHave(exactText("Результаты поиска"));
            page.input().shouldHave(exactValue("Genshin Impact"));
    }



     @Test
    //  4. Снизу всегда есть подсказка: "Поиск страниц содержащих", при клике на нее выполняется переход на страницу поиска.
    public void test4NotFound() {
        MainPage main = new MainPage();
         main.open();
        //  При вводе поискового запроса
        //   Здесь не появлялась ссылка Все запросы содержащие Genshin Impact, пришлось вводить текст не сразу а частями
        main.search2( "gensh");
        // при клике на нее выполняется переход на страницу поиска.
        main.linkGoAllResults().click();
        //  переходим на первую подсказку саджеста, если он был.
        SearchResultsPage page= new SearchResultsPage();
            page.title().shouldHave(exactText("Результаты поиска"));
            page.input().shouldHave(exactValue("gensh"));
    }


}