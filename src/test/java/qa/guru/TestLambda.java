package qa.guru;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestLambda {

    private static final String REPOSITORY = "Alexia910/qa-guru-hw5";

    @Test
    void testLambda() {

        step("Открыть главную страницу", () -> {
            open("https://github.com/");
        });

        step("Поиск репозитория " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Проверить то, что репозиторий " + REPOSITORY + " найден", () -> {
            $(".repo-list").should(text("Alexia910/qa-guru-hw5"));
        });

        step("Открыть репозиторий " + REPOSITORY, () -> {
            $(By.linkText("Alexia910/qa-guru-hw5")).click();
        });

        step("Проверить наличие вкладки issues", () -> {
            $("#issues-tab").should(text("issues"));
        });
    }
}
