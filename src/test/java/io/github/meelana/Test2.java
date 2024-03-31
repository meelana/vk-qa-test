package io.github.meelana;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class Test2 {

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl =  "https://ru.wikipedia.org";
    }

    @Test
     // 2. Переход из саджеста по поисковой фразе идет в точности на ее страницу.
    public  void test2 () {
        MainPage main = new MainPage();
        main.open();
        main.search("gensh");
        ElementsCollection  results = main.results();
        SelenideElement result1=results.get(0);
        String text=result1.text();
        //  Переход из саджеста по поисковой фразе идет в точности на ее страницу.
        result1.click();
        SearchResultPage page = new SearchResultPage();
        page.title().shouldHave(exactText(text));
    }
}