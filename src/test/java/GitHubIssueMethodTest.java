import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class GitHubIssueMethodTest {
    private static final String REPOSITORY = "t0kke/PracticeInDemoQA";
    private static final String ISSUE_NAME = "Test Issue";

    public BaseSteps step = new BaseSteps();

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step.openMainPage();
        step.searchRepository(REPOSITORY);
        step.goToRepositoryFromSearch(REPOSITORY);
        step.openRepositoryIssues();
        step.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
