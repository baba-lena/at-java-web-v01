package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTests {
    @Test
    public void test01LoginSuccess()

     {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.className("input-group")).shouldBe(visible);
        $(By.tagName("username")).sendKeys("standard_user");
        $(By.tagName("password")).sendKeys("stand_pass1");
         $(By.id("loginButton")).click();
         sleep(10000);


    }
}


