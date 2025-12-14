package demo.part02;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleXPathTests
{
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
    void testSearchContains_Selenide()
        {
            open ("https://slqa.ru/cases/xPathSimpleForm/");
            $(By.className("not_unique_class")).shouldHave(text("Москва"));
        }
    @Test
    void testSearch_Contains_XPath()
        {
            open ("https://slqa.ru/cases/xPathSimpleForm/");
            $x("//*[contains(text(),'Питер')]").shouldHave(text("180 единиц"));
        }
    @Test
    void testSearch_Starts_with_XPath()
        {
            open ("https://slqa.ru/cases/xPathSimpleForm/");
            $x("//*[starts-with(text(),'Казахстан')]").shouldHave(text("площадь 2 724 902"));
        }
// 14.12.2025 Module 3
    @Test
    void testXPathPizza()
         {
            open("https://slqamsk.github.io/cases/pizza/v08/");
            SelenideElement se1 = $x("//h3[.='Маргарита']");
            System.out.println("Элемент с названием пиццы: тег: " + se1.getTagName() + ", текст: " + se1.text());
            SelenideElement se2 = $x("//h3[.='Маргарита']/..");
            System.out.println("Его родитель: тег: " + se2.getTagName() + ", текст: " + se2.text());
            SelenideElement se3 = $x("//h3[.='Маргарита']/../button");
            System.out.println("Кнопка: тег: " + se3.getTagName() + ", текст: " + se3.text());
         }

}