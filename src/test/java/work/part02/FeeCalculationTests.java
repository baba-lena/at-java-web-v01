package work.part02;

import com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FeeCalculationTests {
    @Test
    public void test01() {
        open("https://slqamsk.github.io/demo/search-demo/");
       // $(By.name("sum")).sendKeys("ТЕКСТ");
        sleep(10000);
        $(By.name("sum")).sendKeys("НОВЫЙ ТЕКСТ");
        $(By.name("cancel_btn")).click();
        sleep(10000);
    }
}