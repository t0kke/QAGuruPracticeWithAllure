import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubIssueMethodStepTest {
    private static final String REPOSITORY = "t0kke/PracticeInDemoQA";
    private static final String ISSUE_NAME = "Test Issue";

    @Test
    public void testIssueSearch() {
        step("Открываем главную страницу", () -> open("https://github.com/"));
        step("Ищем репозиторий" + REPOSITORY, () ->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем на репозиторий" + REPOSITORY, () -> $(By.linkText(REPOSITORY)).click());
        step("Кликаем по вкладке Issues", () -> $(withText("Issues")).click());
        step("Проверяем, что Issue с именем" + ISSUE_NAME + "существует", () ->{
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}
