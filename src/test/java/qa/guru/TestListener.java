package qa.guru;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestListener {
    @Test
    void testListener() {
        //Добавление listener
        SelenideLogger.addListener("allur", new AllureSelenide());
        //Открыть главную страницу github
        open("https://github.com/");
        //Ввести в поиск название страницы "Alexia910/qa-guru-hw5"
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Alexia910/qa-guru-hw5");
        $(".header-search-input").submit();
        //Проверка наличия репозитория на странице
        $(".repo-list").should(text("Alexia910/qa-guru-hw5"));
        $(By.linkText("Alexia910/qa-guru-hw5")).click();
        //Проверить наличие поля Issue
        $("#issues-tab").should(text("issues"));
    }
}

