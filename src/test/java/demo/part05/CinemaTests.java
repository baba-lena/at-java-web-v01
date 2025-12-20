package demo.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
       String dateValue = "26-12-2025";
       $("input[name='date']").setValue(dateValue);
       $x("//input[@name='session' and @value='8']").click();
       $x("//input[@name='film' and @value='crime']").click();
       $("input[type=submit").click();
       $("div").shouldHave(text("Стоимость билета: 400 рублей."));
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


    @ParameterizedTest
    @MethodSource("provideCinemaData")
    void test03_simple_cinema (int age, String dateValue, String start, String film, String priceMessage)
    {
        open(url);
        $("input[name=age]").setValue(String.valueOf(age));
        $("input[name='date']").setValue(dateValue);
        $("input[name=session][value='" + start + "']").click();
        $("input[name=film][value='" + film  + "']").click();
        $("input[type=submit").click();
        $("div").shouldHave(text(priceMessage));
    }
    static Stream<Arguments> provideCinemaData() {
        Stream.Builder<Arguments> argumentsBuilder = Stream.builder();
        argumentsBuilder.add(Arguments.of("35", "21-12-2025", "1", "back",  "Стоимость билета: 450 рублей."));
        argumentsBuilder.add(Arguments.of("20", "22-12-2025", "2", "crime", "Стоимость билета: 350 рублей."));
        argumentsBuilder.add(Arguments.of("5",  "23-12-2025", "3", "king",  "Стоимость билета: 100 рублей."));
        return argumentsBuilder.build();
    }




}
