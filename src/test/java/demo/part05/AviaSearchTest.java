package demo.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AviaSearchTest {


     private final String url = "https://slqamsk.github.io/cases/slflights/v01/";

     @BeforeEach
     void setUp()
     {
        Configuration.browser = "chrome";
     }

     @Test
     void test01 ()
     {
        open(url);
         $("#username").setValue("standard_user");
         $("#password").setValue("stand_pass");
         $("#loginButton").click();
         $("#message").shouldHave(text("Неверное имя пользователя или пароль."));
     }
    @Test
    void test02 ()
    {
        open(url);
        $("#username").setValue("standard_user");
        $("#password").setValue("stand_pass1");
        $("#loginButton").click();
        $("#departureDate").setValue("");
        $x("//button[.='Найти']").click();
        $("#searchMessage").shouldHave(text("Пожалуйста, укажите дату вылета."));
    }

}
