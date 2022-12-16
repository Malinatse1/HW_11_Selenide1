package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class CheckCodeJunit {

    @Test
    @DisplayName("Проверка что внутри страницы SoftAssertions есть пример кода для Junit5")
    @Tag("Позитивный кейс")
    public void TestSelenideCheckCodeJunit(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу Github",() ->
        {open("https://github.com/");
        });

        step ("Открыть страницу Selenide в Github",() -> {
         $(".header-search-input").click();
         $(".header-search-input").sendKeys("Selenide");
         $(".header-search-input").pressEnter();
        });

        step ("Перейти в раздел Wiki проекта",() -> {
            $(linkText("Wikis")).click();
        });

        step (" Проверка, что в списке страниц (Pages) есть страница SoftAssertions",() -> {
            $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        });

        step ("Открыть страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5",() -> {
            $(linkText("SoftAssertions")).click();
            $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
        });

    }


}
