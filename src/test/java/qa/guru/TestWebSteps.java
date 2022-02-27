package qa.guru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class TestWebSteps {
    private static final String REPO = "Alexia910/qa-guru-hw5";

    @Test
    void webSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPO);
        steps.checkRepository(REPO);
        steps.openRepository(REPO);
        steps.checkIssueTab();

    }
}
