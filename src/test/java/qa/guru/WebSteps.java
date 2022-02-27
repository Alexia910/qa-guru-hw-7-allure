package qa.guru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Поиск репозитория {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Проверить то, что репозиторий {repo} найден")
    public void checkRepository(String repo) {
        $(".repo-list").should(text("Alexia910/qa-guru-hw5"));
    }

    @Step("Открыть репозиторий {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Проверить наличие вкладки issues")
    public void checkIssueTab() {
        $("#issues-tab").should(text("issues"));
    }

}
