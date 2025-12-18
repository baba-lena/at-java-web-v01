package demo.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CinemaTests
{
    private final String url = "http://92.51.36.108:7777/sl.qa/cinema/index.php";

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
    }

   @Test
   void test01_simple_cinema ()
   {
       open(url);
       $("input[name=age]").setValue("39");
       String dateValue = "20-12-2025";
       $("input[name='date']").setValue(dateValue);
       $x("//input[@name='session' and @value='8']").click();
       $x("//input[@name='film' and @value='crime']").click();
       $("input[type=submit").click();
       $("div").shouldHave(text("Стоимость билета: 500 рублей."));
   }

    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    void test02_simple_cinema (int age, String dateValue, String start, String film, String priceMessage)
    {
        open(url);
        $("input[name=age]").setValue(String.valueOf(age));
        $("input[name='date']").setValue(dateValue);
        $("input[name=session][value='" + start + "']").click();
        $("input[name=film][value='" + film  + "']").click();
        $("input[type=submit").click();
        $("div").shouldHave(text(priceMessage));
    }







}
