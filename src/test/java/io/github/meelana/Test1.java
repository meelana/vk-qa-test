package io.github.meelana;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class Test1 {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl =  "https://ru.wikipedia.org";
    }

    @Test
    // 1. При вводе первые саджесты начинаются на поисковый запрос. Далее на усмотрение поискового движка. Поисковый запрос выделяется жирным шрифтом.
    public void test1 () {
        MainPage main = new MainPage();
        main.open();
        main.search("Gensh" );
            ElementsCollection results = main.results();
        SelenideElement result1 =results.get(0);
        SelenideElement result2 =results.get(1);
         // При вводе первые саджесты начинаются на поисковый запрос. Далее на усмотрение поискового движка.
        // Проверяются первые две
        SelenideElement bold1=result1.find(".highlight");
        SelenideElement bold2=result2.find(".highlight");
        result1.shouldHave( matchText("^Gensh"));
        result2.shouldHave( matchText("^Gensh"));
         // Поисковый запрос выделяется жирным шрифтом.
        bold1.shouldHave(cssValue( "font-weight",  "700"));
        bold2.shouldHave(cssValue("font-weight",  "700"));

    }
}