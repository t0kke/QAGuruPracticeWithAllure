import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest {

    private static final String REPOSITORY = "t0kke/PracticeInDemoQA";
    private static final String ISSUE_NAME = "Test Issue";
    @Test
    public void testIssueSearchWithName() {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }
}
