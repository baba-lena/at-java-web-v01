package demo.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleXPathTests {
// 07.12.2025. Practice_Module_2
    @Test
    void testSpecialParagraph()
    {
        open("https://slqamsk.github.io/tmp/xPath01.html");
        $x("//p[@class='special-paragraph']")
                .shouldHave(exactText("Этот параграф особенный - он единственный на странице с таким классом."));
    }

// 07.12.2025. Homework_Module_2
    @Test
    void testSearchContains()
        {
            open ("https://slqa.ru/cases/xPathSimpleForm/");
            $(By.className("not_unique_class")).shouldHave(text("Москва"));
        }
    @Test
    void testSearch_Contains_XPath()
        {
            open ("https://slqa.ru/cases/xPathSimpleForm/");
            $x("//p[contains(text(),'Питер'");
        }

    @Test
    void testSearch_Starts_with_XPath()
        {
            open ("https://slqa.ru/cases/xPathSimpleForm/");
            $x("//*[starts-with(text(),'Казахстан')]").shouldHave(text("площадь 2 724 902"));
        }
}