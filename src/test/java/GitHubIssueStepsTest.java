import com.codeborne.selenide.Condition;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubIssueStepsTest {
    private static final String REPOSITORY = "t0kke/PracticeInDemoQA";
    private static final String ISSUE_NAME = "Test Issue";
    private static final String BASE_URL = "https://github.com/";

    @Test
    @DisplayName("Поиск Issue по названию")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> open(BASE_URL));
        step("Ищем репозиторий  " + REPOSITORY, () ->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем на репозиторий " + REPOSITORY, () -> $(By.linkText(REPOSITORY)).click());
        step("Кликаем по вкладке Issues", () -> $(withText("Issues")).click());
        step("Проверяем, что Issue с именем " + ISSUE_NAME + "существует", () ->{
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}
