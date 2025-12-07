package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class AuthorizationTests {
    @Test
   public void test01LoginSuccess()

     {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("stand_pass1");
         $(By.id("loginButton")).click();
         $(By.id("flightForm")).shouldBe(visible);
     }

    public void test02LoginWrongPassword()

    {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("wrong_pass");
        $(By.id("loginButton")).click();
        $(By.className("error")).shouldHave(text("Неверное имя пользователя или пароль."));
    }


}


