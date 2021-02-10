import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest {
    @Test
    public void testIssueSearchWithName() {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("t0kke/PracticeInDemoQA");
        $(".header-search-input").submit();
        $(By.linkText("t0kke/PracticeInDemoQA")).click();
        $(withText("Issues")).click();
        $(withText("Test Issue")).should(Condition.exist);
    }
}
