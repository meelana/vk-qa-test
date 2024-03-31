package io.github.meelana;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    public SelenideElement title() {
        return $(By.id("firstHeading"));
    }

    public SelenideElement input() {
        return $( By.id("ooui-php-1"));
    }
}
