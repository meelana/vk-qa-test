package io.github.meelana;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class Test3 {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl =  "https://ru.wikipedia.org";
    }

    @Test
     // 3. При вводе поискового запроса и нажатии кнопки поиск (лупа справа) - переходим на первую подсказку саджеста, если он был. Если не было - на страницу поиска. (Иван - переходит на страницу Иван, Иваннннн переходит на поиск с вхождением Иваннннн)
    public void test3Found() {
        MainPage main = new MainPage();
        main.open();
         // При вводе поискового запроса
         main.search( "Genshin Impact");
        ElementsCollection results = main.results();
        SelenideElement result1 = results.get(0);
        String text =result1.text();
        // и нажатии кнопки поиск (лупа справа)
        main.buttonClick();
        // переходим на первую подсказку саджеста, если он был.
        SearchResultPage page = new SearchResultPage();
         page.title().shouldHave(exactText(text));
    }

    @Test
     // 3. При вводе поискового запроса и нажатии кнопки поиск (лупа справа) - переходим на первую подсказку саджеста, если он был. Если не было - на страницу поиска. (Иван - переходит на страницу Иван, Иваннннн переходит на поиск с вхождением Иваннннн)
    public void test3NotFound () {
        MainPage main = new MainPage();
        main.open();
        // При вводе поискового запроса
        main.search ("gensh");
        //   и нажатии кнопки поиск (лупа справа)
        main.buttonClick();
        // Если не было - на страницу поиска.
        SearchResultsPage page= new SearchResultsPage();
        page.title().shouldHave(exactText("Результаты поиска" ));
        //  Иваннннн переходит на поиск с вхождением Иваннннн)
         page.input().shouldHave(exactValue("gensh"));
    }
}